Use Windows.pkg
Use DFClient.pkg
Use File_dlg.pkg
Use Pacotes\GGGLerXmls.pkg
Use Pacotes\GGGwsGeraGuia.pkg
Use Pacotes\GGGwsBuscaGuia.pkg

Deferred_View Activate_oExemplo2 for ;
Object oExemplo2 is a dbView
    
    Property tWStRetornoLote ptLoteGuias
    
    Set Border_Style to Border_Thick
    Set Size to 300 399
    Set Location to 6 6
    Set Label to "GeraGuia"

    Object oOpenDialog1 is a OpenDialog
        Set Filter_String to 'NFe|*.xml'
        Set MultiSelect_State to True
    End_Object

    Object oGrid1 is a Grid
        Set Location to 7 8
    
        Set Size to 155 382
    
        Set Line_Width to 1 0
        Set Header_Label 0 to "XMLs para processar"
        Set Form_Width 0 to 373
        Set Color to claqua    
    End_Object

    Object oButtonCarregaXml is a Button
        Set Size to 14 151
        Set Location to 165 8
        Set Label to 'Pressione aqui para localizar e carregar as XMLs'
    
        // fires when the button is clicked
        Procedure OnClick
            Boolean bOpen bReadOnly
            Integer iCount
            String sFileTitle sFileName
            String[] saSelectedFiles
         
            Get Show_Dialog of oOpenDialog1 to bOpen
            If bOpen Begin
                Get TickReadOnly_State of oOpenDialog1 to bReadOnly
                Get File_Title of oOpenDialog1 to sFileTitle
                Get Selected_Files of oOpenDialog1 to saSelectedFiles
                
                Send Delete_Data of oGrid1
                
                For iCount from 0 to ((SizeOfArray(saSelectedFiles)) - 1)
                    Send Add_Item of oGrid1 Msg_None saSelectedFiles[iCount]
                Loop
            End
            Else Send Info_Box "Nenhum arquivo foi escolhido."
        End_Procedure

            
    
    End_Object

    Object oLogin is a Form
        Set Size to 13 196
        Set Location to 183 71
        Set Label to "Login:"
        Set FontWeight to 600
    End_Object

    Object oCNPJ is a Form
        Set Size to 13 93
        Set Location to 198 71
        Set Label to "CNPJ:"
        Set FontWeight to 600
    End_Object

    Object oToken is a Form
        Set Size to 13 196
        Set Location to 213 71
        Set Label to "Token/Chave Api:"
        Set FontWeight to 600
    End_Object

    Object oGroupRetornoEstrutura is a Group
        Set Size to 64 189
        Set Location to 230 10
        Set Label to "Retornos em estrutura de dados"

        Object oButtonGeraGuia is a Button
            Set Size to 14 83
            Set Location to 10 8
            Set Label to "Gerar Guias e exibir na tela"
            
            Procedure OnClick
                Send GeraGuia                
            End_Procedure
            
            Procedure GeraGuia
                String[] saLista
                Integer iLinhas iContador
                tWStListaNfe    ListaNFe
                tWStRetornoLote RetornoLote
                tWStListaGuias  ListaGuias
                
                // Lista de c¢digos de retorno: 
                // 0 = Sucesso
                // 1 = N∆o autorizado. Verifique o CNPJ, Usu†rio e Token.
                // 2 = Lote processado com pendàncias.
                // 3 = Nenhuma guia liberada no momento.
                // 4 = Falha ao buscar guias. 
                // 5 = Falha ao gerar o PDF.
                // 6 = Data inicial inv†lida. Padr∆o esperado: AAAA-MM-DD. 
                // 7 = Data final inv†lida. Padr∆o esperado: AAAA-MM-DD.
                
                Send Cursor_Wait of Cursor_Control
                
                Send Beginning_of_Data of oGrid1
                
                Get Item_Count of oGrid1 to iLinhas
                
                For iContador from 0 to (iLinhas - 1)
                    Get Value of oGrid1 item iContador to saLista[iContador]
                Loop
                
                // Extrai as informaá‰es das xmls para a estrutura de lista de notas
                Get GGGLerXmls saLista (Value(oCNPJ,0)) to ListaNFe
                
                // Consome o webservice e gera as guias no portal
                Get GGGGeraGuia (Value(oCNPJ,0)) (Value(oLogin,0)) (Value(oToken,0)) ListaNFe to RetornoLote 
                
                // RetornoLote.retorno = 0 -> Sucesso.
                If (RetornoLote.retorno > 0);
                Begin
                    Error DFERR_OPERATOR ("Pendàncias na geraá∆o das guias.\nC¢digo do retorno: " + (String(RetornoLote.retorno)) + " - Descriá∆o: " + (RetornoLote.msg_retorno))
                End
                
                // Consome o webservice e recebe de volta os dados das guias para serem utilizadas como quiser (gravaá∆o, exportaá∆o, impress∆o em algum gerador de relat¢rio, etc.)
                // O XML de retorno completo da guia est† no campo ListaGuias.guias[n].xml_guia
                Get GGGBuscaGuia (Value(oCNPJ,0)) (Value(oLogin,0)) (Value(oToken,0)) RetornoLote to ListaGuias
                
                If (ListaGuias.retorno > 0);
                Begin
                    Error DFERR_OPERATOR ("Pendàncias na busca das guias.\n\nC¢digo do retorno: " + (String(ListaGuias.retorno)) + "\nDescriá∆o: " + (ListaGuias.msg_retorno))
                End
                
                // Neste exemplo, vamos apenas mostrar na tela o retorno da estrutura de guias.
                For iContador from 0 to ((SizeOfArray(ListaGuias.guias))-1)
                    Showln ("emitente:                " + (String(ListaGuias.guias[iContador].emitente)))
                    Showln ("serie:                   " + (String(ListaGuias.guias[iContador].serie)))
                    Showln ("modelo:                  " + (String(ListaGuias.guias[iContador].modelo)))
                    Showln ("num_nota_fiscal:         " + (String(ListaGuias.guias[iContador].num_nota_fiscal)))
                    Showln ("receita:                 " + (String(ListaGuias.guias[iContador].receita)))
                    Showln ("detalhamento:            " + (String(ListaGuias.guias[iContador].detalhamento)))
                    Showln ("tipo_Documento:          " + (String(ListaGuias.guias[iContador].tipo_Documento)))
                    Showln ("chave_nfe:               " + (String(ListaGuias.guias[iContador].chave_nfe)))
                    Showln ("convenio:                " + (String(ListaGuias.guias[iContador].convenio)))
                    Showln ("data_emissao:            " + (String(ListaGuias.guias[iContador].data_emissao)))
                    Showln ("status:                  " + (String(ListaGuias.guias[iContador].status)))
                    Showln ("recibo:                  " + (String(ListaGuias.guias[iContador].recibo)))
                    Showln ("data_recibo:             " + (String(ListaGuias.guias[iContador].data_recibo)))
                    Showln ("produto:                 " + (String(ListaGuias.guias[iContador].produto)))
                    Showln ("vencimento:              " + (String(ListaGuias.guias[iContador].vencimento)))
                    Showln ("valor:                   " + (String(ListaGuias.guias[iContador].valor)))
                    Showln ("cpf:                     " + (String(ListaGuias.guias[iContador].cpf)))
                    Showln ("cnpj:                    " + (String(ListaGuias.guias[iContador].cnpj)))
                    Showln ("nome_destinatario:       " + (String(ListaGuias.guias[iContador].nome_destinatario)))
                    Showln ("municipio_destinatario:  " + (String(ListaGuias.guias[iContador].municipio_destinatario)))
                    Showln ("cod_municipio_destinat:  " + (String(ListaGuias.guias[iContador].cod_municipio_destinat)))
                    Showln ("uf_destinatario:         " + (String(ListaGuias.guias[iContador].uf_destinatario)))
                    Showln ("mensagem:                " + (String(ListaGuias.guias[iContador].mensagem)))
                    Showln ("xml_guia:                " + (String(ListaGuias.guias[iContador].xml_guia)))
                    Showln ("data_recepcao:           " + (String(ListaGuias.guias[iContador].data_recepcao)))
                    Showln ("valor_atualizado:        " + (String(ListaGuias.guias[iContador].valor_atualizado)))
                    Showln ""
                Loop
                
                // Move RetornoLote para uma propriedade da view, apenas para ser usada ao clicar nos bot‰es 'Busca Guia',
                // 'Pendentes', 'Todas Com Erro', 'Todas Pendentes', j† que Ç preciso uma estrutura dessa para ser usada como parÉmetro, na busca de guias.
                Set ptLoteGuias of oExemplo2 to RetornoLote
                
                Send Cursor_Ready of Cursor_Control
            End_Procedure
        
        End_Object

        Object oButtonBuscaGuia is a Button
            Set Size to 14 84
            Set Location to 10 97
            Set Label to "Busca Guia"
            
            Procedure OnClick
                Send BuscaGuia                        
            End_Procedure
            
            Procedure BuscaGuia
                Integer iIndex iContador iSize
                tWStListaGuias ListaGuias
                tWStRetornoLote Lote
                
                // Lista de c¢digos de retorno: 
                // 0 = Sucesso
                // 1 = N∆o autorizado. Verifique o CNPJ, Usu†rio e Token.
                // 2 = Lote processado com pendàncias.
                // 3 = Nenhuma guia liberada no momento.
                // 4 = Falha ao buscar guias. 
                // 5 = Falha ao gerar o PDF.
                // 6 = Data inicial inv†lida. Padr∆o esperado: AAAA-MM-DD. 
                // 7 = Data final inv†lida. Padr∆o esperado: AAAA-MM-DD.
                
                Send Cursor_Wait of Cursor_Control
                
                Get ptLoteGuias of oExemplo2 to Lote
                
                // Esta funá∆o, GGGBuscaGuia, exige uma estrutura de dados de retorno, com os recibos, etc, como parÉmetro.
                // Como n∆o estamos guardando nada em banco, guardamos o retorno da chamada de GeraGuia, para ser carregada aqui 
                // como exemplo.
                Get GGGBuscaGuia (Value(oCNPJ,0)) (Value(oLogin,0)) (Value(oToken,0)) Lote to ListaGuias
                
                If (ListaGuias.retorno > 0);
                Begin
                    Error DFERR_OPERATOR ("Pendàncias na busca das guias.\n\nC¢digo do retorno: " + (String(ListaGuias.retorno)) + "\nDescriá∆o: " + (ListaGuias.msg_retorno))
                End
                
                For iContador from 0 to ((SizeOfArray(ListaGuias.Guias))-1)
                    Showln ("emitente:                " + (String(ListaGuias.Guias[iContador].emitente)))
                    Showln ("serie:                   " + (String(ListaGuias.Guias[iContador].serie)))
                    Showln ("modelo:                  " + (String(ListaGuias.Guias[iContador].modelo)))
                    Showln ("num_nota_fiscal:         " + (String(ListaGuias.Guias[iContador].num_nota_fiscal)))
                    Showln ("receita:                 " + (String(ListaGuias.Guias[iContador].receita)))
                    Showln ("detalhamento:            " + (String(ListaGuias.Guias[iContador].detalhamento)))
                    Showln ("tipo_Documento:          " + (String(ListaGuias.Guias[iContador].tipo_Documento)))
                    Showln ("chave_nfe:               " + (String(ListaGuias.Guias[iContador].chave_nfe)))
                    Showln ("convenio:                " + (String(ListaGuias.Guias[iContador].convenio)))
                    Showln ("data_emissao:            " + (String(ListaGuias.Guias[iContador].data_emissao)))
                    Showln ("status:                  " + (String(ListaGuias.Guias[iContador].status)))
                    Showln ("recibo:                  " + (String(ListaGuias.Guias[iContador].recibo)))
                    Showln ("data_recibo:             " + (String(ListaGuias.Guias[iContador].data_recibo)))
                    Showln ("produto:                 " + (String(ListaGuias.Guias[iContador].produto)))
                    Showln ("vencimento:              " + (String(ListaGuias.Guias[iContador].vencimento)))
                    Showln ("valor:                   " + (String(ListaGuias.Guias[iContador].valor)))
                    Showln ("cpf:                     " + (String(ListaGuias.Guias[iContador].cpf)))
                    Showln ("cnpj:                    " + (String(ListaGuias.Guias[iContador].cnpj)))
                    Showln ("nome_destinatario:       " + (String(ListaGuias.Guias[iContador].nome_destinatario)))
                    Showln ("municipio_destinatario:  " + (String(ListaGuias.Guias[iContador].municipio_destinatario)))
                    Showln ("cod_municipio_destinat:  " + (String(ListaGuias.Guias[iContador].cod_municipio_destinat)))
                    Showln ("uf_destinatario:         " + (String(ListaGuias.Guias[iContador].uf_destinatario)))
                    Showln ("mensagem:                " + (String(ListaGuias.Guias[iContador].mensagem)))
                    Showln ("xml_guia:                " + (String(ListaGuias.Guias[iContador].xml_guia)))
                    Showln ("data_recepcao:           " + (String(ListaGuias.Guias[iContador].data_recepcao)))
                    Showln ("valor_atualizado:        " + (String(ListaGuias.Guias[iContador].valor_atualizado)))
                Loop
                
                Send Cursor_Ready of Cursor_Control
            End_Procedure
        
        End_Object
        
        Object oButtonPendentes is a Button
            Set Size to 14 84
            Set Location to 27 8
            Set Label to "Pendentes"
        
            Procedure OnClick
                    Send BuscaPendentes
            End_Procedure
            
            Procedure BuscaPendentes
                Integer iIndex iContador iSize
                tWStListaGuias ListaGuias
                tWStRecibos GuiasPendentes
                tWStRetornoLote Lote
                
                // Lista de c¢digos de retorno: 
                // 0 = Sucesso
                // 1 = N∆o autorizado. Verifique o CNPJ, Usu†rio e Token.
                // 2 = Lote processado com pendàncias.
                // 3 = Nenhuma guia liberada no momento.
                // 4 = Falha ao buscar guias. 
                // 5 = Falha ao gerar o PDF.
                // 6 = Data inicial inv†lida. Padr∆o esperado: AAAA-MM-DD. 
                // 7 = Data final inv†lida. Padr∆o esperado: AAAA-MM-DD.
                
                Send Cursor_Wait of Cursor_Control
                
                // Esta funá∆o, GGGBuscaGuiasPendentes, exige uma estrutura de dados de guias pendentes, como parÉmetro.
                // Como n∆o estamos guardando nada em banco, usaremos de novo o retorno da chamada de GeraGuia, 
                // guardado na propriedade ptLoteGuias, para ser carregada aqui como exemplo.
                // Para localizar estas guias pendentes dentro deste lote, vamos varre-lo eliminando as
                // guias que j† est∆o autorizadas, e buscar apenas as que n∆o foram retornadas na busca anterior. 
                Get ptLoteGuias of oExemplo2 to Lote
                
                Move (SizeOfArray(Lote.recibos)) to iSize
                Decrement iSize
                
                For iContador from 0 to iSize
                    If (Lote.recibos[iIndex].status = "Autorizado") Begin
                        Move (RemoveFromArray(Lote.recibos, iIndex)) to Lote.recibos
                    End
                    Else Begin
                        Move (Lote.recibos[iIndex].emitente) to GuiasPendentes.emitente
                        Move (Lote.recibos[iIndex].recibo)   to GuiasPendentes.recibo[iIndex]
                        Increment iIndex
                    End
                Loop
                
                Get GGGBuscaGuiasPendentes (Value(oCNPJ,0)) (Value(oLogin,0)) (Value(oToken,0)) GuiasPendentes to ListaGuias
                
                If (ListaGuias.retorno > 0);
                Begin
                    Error DFERR_OPERATOR ("Pendàncias na busca das guias.\n\nC¢digo do retorno: " + (String(ListaGuias.retorno)) + "\nDescriá∆o: " + (ListaGuias.msg_retorno))
                End
                
                For iContador from 0 to ((SizeOfArray(ListaGuias.Guias))-1)
                    Showln (String(ListaGuias.Guias[iContador].Recibo)) ""
                Loop
                
                Send Cursor_Ready of Cursor_Control
            End_Procedure
        
        End_Object
        Object oButtonTodasErro is a Button
            Set Size to 14 84
            Set Location to 44 8
            Set Label to "Todas Com Erro"
        
            Procedure OnClick
                    Send BuscaTodasComErro
            End_Procedure
            
            Procedure BuscaTodasComErro
                Integer iRet iContador
                String sDataFinal
                tWStListaGuias ListaGuias
                
                // Lista de c¢digos de retorno: 
                // 0 = Sucesso
                // 1 = N∆o autorizado. Verifique o CNPJ, Usu†rio e Token.
                // 2 = Lote processado com pendàncias.
                // 3 = Nenhuma guia liberada no momento.
                // 4 = Falha ao buscar guias. 
                // 5 = Falha ao gerar o PDF.
                // 6 = Data inicial inv†lida. Padr∆o esperado: AAAA-MM-DD. 
                // 7 = Data final inv†lida. Padr∆o esperado: AAAA-MM-DD.
                
                Send Cursor_Wait of Cursor_Control
                
                // A funá∆o GGGBuscaTodasGuiasComErro busca todas as guias com erro em um intervalo de tempo passado como parÉmetro, e
                // tenta retransmit°-las para a SEFAZ de destino e trazer o resultado desse reenvio. Se passado apenas a data inicial,
                // ele buscar† as guias com erro a partir (e inclusive) desta data. Se passado apenas a data final, ele buscar† todas 
                // as guias com erro, desde o primeiro registro da empresa no sistema, atÇ esta data informada. Se nenhuma data for 
                // informada, ele buscar† em todos os registros da empresa por guias com erro, o que pode demorar demais.
                // Formato esperado da data: AAAA-MM-DD
                
                Move ((String(DateGetYear(CurrentDateTime()))) + "-") to sDataFinal
                Move (DateGetMonth(CurrentDateTime())) to iRet
                Move (sDataFinal + (If((iRet<=9), ("0" + (String(iRet))), (String(iRet)))) + "-") to sDataFinal
                Move (DateGetDay(CurrentDateTime())) to iRet
                Move (sDataFinal + (If((iRet<=9), ("0" + (String(iRet))), (String(iRet))))) to sDataFinal
                
                Get GGGBuscaTodasGuiasComErro (Value(oCNPJ,0)) (Value(oLogin,0)) (Value(oToken,0)) "2016-01-01" sDataFinal to ListaGuias
                
                If (ListaGuias.retorno > 0);
                Begin
                    Error DFERR_OPERATOR ("Pendàncias na busca das guias.\n\nC¢digo do retorno: " + (String(ListaGuias.retorno)) + "\nDescriá∆o: " + (ListaGuias.msg_retorno))
                End
                
                For iContador from 0 to ((SizeOfArray(ListaGuias.Guias))-1)
                    Showln (String(ListaGuias.Guias[iContador].Recibo)) ""
                Loop
                
                Send Cursor_Ready of Cursor_Control
            End_Procedure
        
        End_Object
        Object oButtonTodasPend is a Button
            Set Size to 14 84
            Set Location to 27 97
            Set Label to "Todas Pendentes"
        
            // fires when the button is clicked
            Procedure OnClick
                Send BuscaTodasPendentes
            End_Procedure
            
            Procedure BuscaTodasPendentes
                Integer iRet iContador
                String sDataFinal
                tWStListaGuias ListaGuias
                
                // Lista de c¢digos de retorno: 
                // 0 = Sucesso
                // 1 = N∆o autorizado. Verifique o CNPJ, Usu†rio e Token.
                // 2 = Lote processado com pendàncias.
                // 3 = Nenhuma guia liberada no momento.
                // 4 = Falha ao buscar guias. 
                // 5 = Falha ao gerar o PDF.
                // 6 = Data inicial inv†lida. Padr∆o esperado: AAAA-MM-DD. 
                // 7 = Data final inv†lida. Padr∆o esperado: AAAA-MM-DD.
                
                Send Cursor_Wait of Cursor_Control
                            
                // A funá∆o GGGBuscaTodasGuiasPendentes busca todas as guias que estavam em processamento e n∆o retornaram
                // na busca anterior, em um intervalo de tempo passado como parÉmetro, e tenta retransmit°-las para a SEFAZ
                // de destino e trazer o resultado desse reenvio. Se passado apenas a data inicial, ele buscar† as guias com
                // erro a partir (e inclusive) desta data. Se passado apenas a data final, ele buscar† todas as guias com 
                // erro, desde o primeiro registro da empresa no sistema, atÇ esta data informada. Se nenhuma data for 
                // informada, ele buscar† em todos os registros da empresa por guias com erro, o que pode demorar demais.
                // Formato esperado da data: AAAA-MM-DD
                
                Move ((String(DateGetYear(CurrentDateTime()))) + "-") to sDataFinal
                Move (DateGetMonth(CurrentDateTime())) to iRet
                Move (sDataFinal + (If((iRet<=9), ("0" + (String(iRet))), (String(iRet)))) + "-") to sDataFinal
                Move (DateGetDay(CurrentDateTime())) to iRet
                Move (sDataFinal + (If((iRet<=9), ("0" + (String(iRet))), (String(iRet))))) to sDataFinal
                
                Get GGGBuscaTodasGuiasPendentes (Value(oCNPJ,0)) (Value(oLogin,0)) (Value(oToken,0)) "2016-01-01" sDataFinal to ListaGuias
                
                If (ListaGuias.retorno > 0);
                Begin
                    Error DFERR_OPERATOR ("Pendàncias na busca das guias.\n\nC¢digo do retorno: " + (String(ListaGuias.retorno)) + "\nDescriá∆o: " + (ListaGuias.msg_retorno))
                End
                
                For iContador from 0 to ((SizeOfArray(ListaGuias.Guias))-1)
                    Showln (String(ListaGuias.Guias[iContador].Recibo)) ""
                Loop
                
                Send Cursor_Ready of Cursor_Control
            End_Procedure
        
        End_Object
    End_Object

    Object oGroupRetornoPDF is a Group
        Set Size to 32 189
        Set Location to 230 202
        Set Label to "Retornos em PDF"
        Object oButtonGuiaPDF is a Button
            Set Size to 14 84
            Set Location to 10 8
            Set Label to "Gera Guia PDF"
        
            Procedure OnClick
                Send GeraGuiaPdf                        
            End_Procedure
            
            Procedure GeraGuiaPdf
                String[] saLista
                String sArq
                Integer iLinhas iContador iCanal
                Boolean bExiste
                tWStListaNfe    ListaNFe
                tWStRetornoLotePDF PdfGuias
                
                // Lista de c¢digos de retorno: 
                // 0 = Sucesso
                // 1 = N∆o autorizado. Verifique o CNPJ, Usu†rio e Token.
                // 2 = Lote processado com pendàncias.
                // 3 = Nenhuma guia liberada no momento.
                // 4 = Falha ao buscar guias. 
                // 5 = Falha ao gerar o PDF.
                // 6 = Data inicial inv†lida. Padr∆o esperado: AAAA-MM-DD. 
                // 7 = Data final inv†lida. Padr∆o esperado: AAAA-MM-DD.
                
                Send Cursor_Wait of Cursor_Control
                
                Send Beginning_of_Data of oGrid1
                
                Get Item_Count of oGrid1 to iLinhas
                
                For iContador from 0 to (iLinhas - 1)
                    Get Value of oGrid1 item iContador to saLista[iContador]
                Loop
                
                // Extrai as informaá‰es das xmls para a array
                Get GGGLerXmls saLista (Value(oCNPJ,0)) to ListaNFe
                                
                // Consome o webservice e recebe de volta o PDF das guias prontas para serem gravadas em disco e impressas.                
                Get GGGGeraGuiaPDF (Value(oCNPJ,0)) (Value(oLogin,0)) (Value(oToken,0)) ListaNFe to PdfGuias
                
                // RetornoLote.retorno = 0 -> Sucesso.
                If (PdfGuias.retorno > 0);
                Begin
                    Error DFERR_OPERATOR ("Pendàncias na geraá∆o das guias.\nC¢digo do retorno: " + (String(PdfGuias.retorno)) + " - Descriá∆o: " + (PdfGuias.msg_retorno))
                End
                
                File_Exist "C:\Temp" bExiste
                If (not(bExiste)) Make_Directory "C:\Temp"
                
                Move (String(CurrentDateTime())) to sArq
                Move (Replaces(" ", sArq, "")) to sArq
                Move (Replaces("/", sArq, "")) to sArq
                Move (Replaces(":", sArq, "")) to sArq
                Move (Replaces(",", sArq, "")) to sArq
                Move ("C:\Temp\PDFGuias_" + sArq + ".pdf") to sArq
                
                Get Seq_New_Channel to iCanal
                If (iCanal = DF_SEQ_CHANNEL_NOT_AVAILABLE) ;
                Begin
                    Error DFERR_OPERATION_NOT_ALLOWED ' Tente novamente !'
                    Procedure_Return
                End
                
                Move 0 to iContador
                
                If (SizeOfArray(PdfGuias.pdf_guias[0].pdf)) Begin   
                    Direct_Output channel iCanal ('BINARY:EOF: -1:' + sArq)
                    While (iContador < (SizeOfArray(PdfGuias.pdf_guias[0].pdf)))
                        Write channel iCanal (Character(PdfGuias.pdf_guias[0].pdf[iContador]))
                        Increment iContador
                    Loop                
                    Close_Output channel iCanal
                End
                
                Send Cursor_Ready of Cursor_Control
                
                File_Exist sArq bExiste
                If bExiste Send Info_Box ("Arquivo " + sArq + " salvo com sucesso.")
            End_Procedure
        End_Object

        Object oButtonBuscaGuiaPDF is a Button
            Set Size to 14 84
            Set Location to 10 97
            Set Label to "Busca Guia PDF"
            
            Procedure OnClick
                Send BuscaGuiaPDF                    
            End_Procedure
            
            Procedure BuscaGuiaPDF
                String sArq
                Integer iCanal i
                Boolean bExiste
                UChar[] PDF
                tWStRetornoLotePDF LotePDF
                tWStRetornoLote Lote
                
                // Lista de c¢digos de retorno: 
                // 0 = Sucesso
                // 1 = N∆o autorizado. Verifique o CNPJ, Usu†rio e Token.
                // 2 = Lote processado com pendàncias.
                // 3 = Nenhuma guia liberada no momento.
                // 4 = Falha ao buscar guias. 
                // 5 = Falha ao gerar o PDF.
                // 6 = Data inicial inv†lida. Padr∆o esperado: AAAA-MM-DD. 
                // 7 = Data final inv†lida. Padr∆o esperado: AAAA-MM-DD.
                
                Send Cursor_Wait of Cursor_Control
                                
                // Esta funá∆o, GGGBuscaGuiaPDF, exige uma estrutura de dados de retorno, com os recibos, etc, como parÉmetro.
                // Como n∆o estamos guardando nada em banco, guardamos o retorno da chamada de GeraGuia, para ser carregada aqui 
                // como exemplo.
                Get ptLoteGuias of oExemplo2 to Lote
                
                Get GGGBuscaGuiaPDF (Value(oCNPJ,0)) (Value(oLogin,0)) (Value(oToken,0)) Lote to LotePDF
                
                If (LotePDF.retorno > 0);
                Begin
                    Error DFERR_OPERATOR ("Pendàncias na busca das guias.\n\nC¢digo do retorno: " + (String(LotePDF.retorno)) + "\nDescriá∆o: " + (LotePDF.msg_retorno))
                End
                
                File_Exist "C:\Temp" bExiste
                If (not(bExiste)) Make_Directory "C:\Temp"
                
                Move (String(CurrentDateTime())) to sArq
                Move (Replaces(" ", sArq, "")) to sArq
                Move (Replaces("/", sArq, "")) to sArq
                Move (Replaces(":", sArq, "")) to sArq
                Move (Replaces(",", sArq, "")) to sArq
                Move ("C:\Temp\PDFGuias_" + sArq + ".pdf") to sArq
                
                Get Seq_New_Channel to iCanal
                If (iCanal = DF_SEQ_CHANNEL_NOT_AVAILABLE) ;
                Begin
                    Error DFERR_OPERATION_NOT_ALLOWED ' Tente novamente !'
                    Procedure_Return
                End       
                
                If (SizeOfArray(LotePDF.pdf_guias[0].pdf)) Begin                
                    Direct_Output channel iCanal ('BINARY:EOF: -1:' + sArq)
                    While (i < (SizeOfArray(LotePDF.pdf_guias[0].pdf)))
                        Write channel iCanal (Character(LotePDF.pdf_guias[0].pdf[i]))
                        Increment i
                    Loop                
                    Close_Output channel iCanal
                End
                
                Send Cursor_Ready of Cursor_Control
                                                
                File_Exist sArq bExiste
                If bExiste Send Info_Box ("Arquivo " + sArq + " salvo com sucesso.")
            End_Procedure
        
        End_Object
    End_Object

Cd_End_Object
