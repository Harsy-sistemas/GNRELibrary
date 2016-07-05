Imports System.IO
Imports System.Text
Module Module1

    Sub Main()
        '*****************************************************************************************************************
        'Atenção: Seu arquivo App.config deve ser semelhante ao descrito abaixo ou poderá ter dificuldades na utilização:
        '
        '<?xml version="1.0" encoding="utf-8" ?>
        '<configuration>
        '    <startup> 
        '        <supportedRuntime version = "v4.0" sku=".NETFramework,Version=v4.5.2" />
        '    </startup>
        '    <system.serviceModel>
        '        <bindings>
        '            <basicHttpBinding>
        '                <binding name = "GeraGuiaGnreSoapBinding" maxReceivedMessageSize="10000000">
        '                    <security mode = "Transport" />
        '                </binding>
        '                <binding name = "GeraGuiaGnreSoapBinding1" />
        '            </basicHttpBinding>
        '                        </bindings>
        '        <client>
        '            <endpoint address = "https://www.guiasgnre.com.br/WEBGNRE/GeraGuiaGnre.wso"
        '                binding = "basicHttpBinding" bindingConfiguration="GeraGuiaGnreSoapBinding"
        '                contract = "ServiceReference1.GeraGuiaGnreSoapType" name="GeraGuiaGnreSoap" />
        '        </client>
        '    </system.serviceModel>
        '</configuration>
        '*****************************************************************************************************************

        ' Manipulador do serviço
        Dim wscall As ServiceReference1.GeraGuiaGnreSoapTypeClient = New ServiceReference1.GeraGuiaGnreSoapTypeClient()
        ' Para chamadas com retorno em PDF
        Dim wsPDF As ServiceReference1.GeraGuiaPDFRequest = New ServiceReference1.GeraGuiaPDFRequest
        Dim wsPDFbody As ServiceReference1.GeraGuiaPDFRequestBody = New ServiceReference1.GeraGuiaPDFRequestBody
        ' Para chamadas sem retorno em PDF
        Dim ws As ServiceReference1.GeraGuiaRequest = New ServiceReference1.GeraGuiaRequest
        Dim wsbody As ServiceReference1.GeraGuiaRequestBody = New ServiceReference1.GeraGuiaRequestBody

        ' Dados da Nota Fiscal
        Dim DadosNfe As ServiceReference1.tDadosNfe = New ServiceReference1.tDadosNfe

        ' Estrutura/Container de notas que serão passadas
        Dim ListaNfe As New ServiceReference1.tListaNfe

        ' RetornoLote recebe o retorno do serviço com o código do resultado no campo 'RetornoLote.retorno', 
        ' a descrição deste código e detalhes da operação em 'RetornoLote.msg_resultado' e os detalhes do recibo do envio dentro 
        ' do array 'RetornoLote.recibos'.
        Dim RetornoLote As New ServiceReference1.tRetornoLote

        ' Recebe o retorno das guias que foram consultadas pelo webservice
        Dim ListaGuias As New ServiceReference1.tListaGuias

        ' Recebe o retorno do lote de PDF
        Dim pdf As New ServiceReference1.tRetornoLotePDF
        Dim pdfByte() As Byte
        Dim oFileStream As FileStream

        ReDim ListaNfe.itens(1)

        ' Dados na NF1
        DadosNfe.emitente = "09141415000150" 'CNPJ da empresa emitente da nota
        DadosNfe.serie = "000" 'Série da NF
        DadosNfe.modelo = "55" 'Modelo do documento (NF-e = 55)
        DadosNfe.num_nota_fiscal = 1577 'Número da nota fiscal
        DadosNfe.tipo_documento = "10"  'Mantenha sempre o código 10 neste campo (Uso interno)
        DadosNfe.chave_nfe = "35160509141415000150550000000015771000015775" 'Chave de acesso da NF-e
        DadosNfe.convenio = "" 'Deixar em branco (Uso interno)
        DadosNfe.data_emissao = "2016-05-25" 'Data de emissão da nota fiscal
        DadosNfe.produto = "" 'Deixar em branco. Caso a UF de destino seja RJ, colocar 698. 
        'Caso a SEFAZ de destino exija a informação do produto, analisar lista de códigos e correspondência 
        'dos produtos no final deste arquivo para passar no próximo envio desta nota.
        DadosNfe.vencimento = "" 'Deixar em branco (Uso interno)
        DadosNfe.valor = 101.82
        DadosNfe.icms_uf_destino = 1.9
        DadosNfe.fcp_uf_destino = 0
        DadosNfe.cnpj = "" 'CNPJ do destinatário. Deixar em branco se for pessoa física e informar somente o CPF abaixo.
        DadosNfe.cpf = "10618969861" 'CPF do destinatário. Deixar em branco se for pessoa jurídica e informar somente o CNPJ acima.
        DadosNfe.nome_destinatario = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL" 'Nome/razão do destinatário.
        DadosNfe.municipio_destinatario = "PORTO ALEGRE" 'Município do destinatário.
        DadosNfe.cod_municipio_destinat = "14902" 'Código IBGE do município.
        DadosNfe.uf_destinatario = "RS" 'Sigla da UF de destino.
        DadosNfe.data_recepcao = "" 'Deixar em branco (Uso interno)

        ListaNfe.itens(0) = DadosNfe

        DadosNfe = Nothing
        DadosNfe = New ServiceReference1.tDadosNfe

        ' Dados na NF2
        DadosNfe.emitente = "09141415000150"
        DadosNfe.serie = "000"
        DadosNfe.modelo = "55"
        DadosNfe.num_nota_fiscal = 1578
        DadosNfe.tipo_documento = "10"
        DadosNfe.chave_nfe = "35160509141415000150550000000015781000015780"
        DadosNfe.convenio = ""
        DadosNfe.data_emissao = "2016-05-25"
        DadosNfe.produto = "698"
        DadosNfe.vencimento = ""
        DadosNfe.valor = 7704.0
        DadosNfe.icms_uf_destino = 201.6
        DadosNfe.fcp_uf_destino = 0
        DadosNfe.cnpj = ""
        DadosNfe.cpf = "10618969861"
        DadosNfe.nome_destinatario = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL"
        DadosNfe.municipio_destinatario = "BELEM"
        DadosNfe.cod_municipio_destinat = "01402"
        DadosNfe.uf_destinatario = "PA"
        DadosNfe.data_recepcao = ""

        ListaNfe.itens(1) = DadosNfe

        ' Primeiro exemplo: Enviando lote de notas para que sejam geradas as respectivas guias.
        ' Parametros da chamada
        wsbody.sEmpresa = "09141415000150" 'CNPJ da empresa emitente das notas, cadastrada no portal.
        wsbody.sUsuario = "seu.email.cadastrado.no.portal@dominio.com.br" 'Seu endereço de e-mail cadastrado no portal GuiasGNRE.
        wsbody.sChaveApi = "XXXXX" 'Sua chave de acesso a API, exibida ao clicar no botão "Cadastro", no portal.
        wsbody.ListaNfe = ListaNfe
        ws.Body = wsbody

        ' Chamando o serviço e gerando as guias. O retorno voltará com o código de erro, mensagem de erro, e lista de recibos das guias geradas.
        RetornoLote = wscall.GeraGuia(wsbody.sEmpresa, wsbody.sUsuario, wsbody.sChaveApi, wsbody.ListaNfe)

        ' Buscando as guias geradas pela chamada anterior, recebendo a lista de guias para serem usadas como quiser, 
        ' seja sendo impressas em um sistema gerador de relatórios, exportadas para um outro sistema, etc.
        ' Aqui, não faremos nada com essa lista, é apenas para fins didáticos.
        ListaGuias = wscall.BuscaGuia(wsbody.sEmpresa, wsbody.sUsuario, wsbody.sChaveApi, RetornoLote)

        ' Agora, usando o mesmo lote de recibos que nos trouxeram a lista de guias na chamada acima, 
        ' vamos buscar essas guias novamente, mas trazendo o PDF destas guias (as que estiverem liberadas apenas).
        pdf = wscall.BuscaGuiaPDF(wsbody.sEmpresa, wsbody.sUsuario, wsbody.sChaveApi, RetornoLote)

        ReDim pdfByte(pdf.pdf_guias(0).pdf.Count)

        pdfByte = pdf.pdf_guias(0).pdf.Cast(Of Byte).ToArray()
        oFileStream = New FileStream("c:\temp\" + pdf.pdf_guias(0).nome + ".pdf", FileMode.CreateNew)
        oFileStream.Write(pdfByte, 0, pdfByte.Length)
        oFileStream.Close()

        pdf = Nothing

        ' Segundo exemplo: Enviando lote de notas para que sejam geradas as respectivas guias e receber o retorno PDF.

        'Vamos passar apenas uma nota desta vez.
        DadosNfe = Nothing
        ListaNfe.itens(0) = Nothing
        ReDim ListaNfe.itens(0)

        DadosNfe = New ServiceReference1.tDadosNfe

        ' Dados na NF3
        DadosNfe.emitente = "09141415000150"
        DadosNfe.serie = "000"
        DadosNfe.modelo = "55"
        DadosNfe.num_nota_fiscal = 1576
        DadosNfe.tipo_documento = "10"
        DadosNfe.chave_nfe = "35160509141415000150550000000015761000015760"
        DadosNfe.convenio = ""
        DadosNfe.data_emissao = "2016-05-25"
        DadosNfe.produto = ""
        DadosNfe.vencimento = ""
        DadosNfe.valor = 4959.45
        DadosNfe.icms_uf_destino = 92.7
        DadosNfe.fcp_uf_destino = 0
        DadosNfe.cnpj = ""
        DadosNfe.cpf = "10618969861"
        DadosNfe.nome_destinatario = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL"
        DadosNfe.municipio_destinatario = "PORTO ALEGRE"
        DadosNfe.cod_municipio_destinat = "14902"
        DadosNfe.uf_destinatario = "RS"
        DadosNfe.data_recepcao = ""

        ListaNfe.itens(0) = DadosNfe

        ' Parametros da chamada
        wsPDFbody.sEmpresa = "09141415000150" 'CNPJ da empresa emitente das notas, cadastrada no portal.
        wsPDFbody.sUsuario = "seu.email.cadastrado.no.portal@dominio.com.br" 'Seu endereço de e-mail cadastrado no portal GuiasGNRE
        wsPDFbody.sChaveApi = "XXXXX" 'Sua chave de acesso a API, exibida ao clicar no botão "Cadastro", no portal.
        wsPDF.Body = wsPDFbody

        pdf = wscall.GeraGuiaPDF(wsPDFbody.sEmpresa, wsPDFbody.sUsuario, wsPDFbody.sChaveApi, wsbody.ListaNfe)

        ReDim pdfByte(pdf.pdf_guias(0).pdf.Count)

        pdfByte = pdf.pdf_guias(0).pdf.Cast(Of Byte).ToArray()
        oFileStream = New FileStream("c:\temp\" + pdf.pdf_guias(0).nome + ".pdf", FileMode.CreateNew)
        oFileStream.Write(pdfByte, 0, pdfByte.Length)
        oFileStream.Close()
    End Sub

    '*******************************************************************************************************************************************************
    ' Lista de Códigos de Produtos
    ' Cód.:   Descrição:
    ' "79"    "Açúcar de cana"                                                                                                                                    
    ' "36"    "Agricultura"                                                                                                                                       
    ' "1"     "Aguardente"                                                                                                                                        
    ' "48"    "Álcool Etílico Anidro"                                                                                                                             
    ' "49"    "Álcool Etílico Hidratado"                                                                                                                          
    ' "2"     "Álcool Etílico Hidratado Combustível (AEHC) e Álcool para fins nãocombustíveis"                                                                    
    ' "3"     "Aparelhos Celulares e Cartão Inteligente (Smart Cards e SimCard)"                                                                                  
    ' "70"    "Aquisição de mercadorias de forma não presencial (internet, telemarketing e showroom)"                                                             
    ' "43"    "Artefatos de Uso Doméstico"                                                                                                                        
    ' "47"    "Artigos de Papelaria"                                                                                                                              
    ' "4"     "Bebidas Alcoólicas (exceto Cervejas, Chopes e Aguardente)"                                                                                         
    ' "81"    "Bebidas Quentes"                                                                                                                                   
    ' "40"    "Bicicletas e Peças"                                                                                                                                
    ' "50"    "Biodiesel B100"                                                                                                                                    
    ' "44"    "Brinquedos"                                                                                                                                        
    ' "71"    "Café Torrado e moído"                                                                                                                              
    ' "72"    "Calçados"                                                                                                                                          
    ' "5"     "Cervejas, Chopes, Refrigerantes, Água Mineral ou Potável, Bebidas Eletrolíticas (Isotônicas e Energéticas, nbm/sh 2106.90 e 2202.90) e Gelo"       
    ' "73"    "Chocolates e preparações similares"                                                                                                                
    ' "6"     "Cigarros e produtos derivados Do fumo"                                                                                                             
    ' "7"     "Cimento"                                                                                                                                           
    ' "8"     "Combustíveis e Lubrificantes, derivados ou não de petróleo, Alcool Etílico Anidro Combustível (AEAC) e BIODIESEL B100"                             
    ' "38"    "Comunicação"                                                                                                                                       
    ' "33"    "Comércio Outros não especificados"                                                                                                                 
    ' "59"    "Coque"                                                                                                                                             
    ' "9"     "Cosméticos, Perfumaria, Artigos de Higiene Pessoal e de Toucador"                                                                                  
    ' "66"    "Derivados de petróleo e demais combustíveis e lubrificantes ­ exceto alcool etílico anidro, alcool etílico hidratado (AEHC) e biodisel ­ B100"     
    ' "10"    "Discos Fonográficos, Fitas Virgens ou Gravadas e Outros Suportes para Reprodução ou Gravação"                                                      
    ' "11"    "Eletrodomésticos, Eletroeletrônicos e Equipamentos de Informática"                                                                                 
    ' "39"    "Energia Elétrica"                                                                                                                                  
    ' "78"    "Extrato concentrados destinado ao preparo de refrigerantes em máquinas (pré­mix e pós­mix)"                                                        
    ' "41"    "Ferramentas"                                                                                                                                       
    ' "12"    "Filmes Fotográficos e Cinematográficos e Slides"                                                                                                   
    ' "13"    "Gado e Produtos Resultantes de seu abate Código Descrição"                                                                                         
    ' "51"    "Gasolina A (sem álcool anidro ­ AEAC)"                                                                                                             
    ' "52"    "Gasolina C (com álcool anidro ­ AEAC)"                                                                                                             
    ' "53"    "Gasolina de Aviação"                                                                                                                               
    ' "63"    "Gás Liquefeito de Petróleo ­ GLP"                                                                                                                  
    ' "62"    "Gás Natural"                                                                                                                                       
    ' "84"    "ICMS Complementar Conv. 110/2007"                                                                                                                  
    ' "34"    "Indústria não especificados"                                                                                                                       
    ' "42"    "Instrumentos Musicais"                                                                                                                             
    ' "74"    "Iogurte"                                                                                                                                           
    ' "77"    "Ladrilhos, placas p/pavimentação, cubos, pastilhas e azulejos"                                                                                     
    ' "64"    "Lubrificantes"                                                                                                                                     
    ' "75"    "Luvas Cirúrgicas e Luvas de Procedimentos"                                                                                                         
    ' "14"    "Lâminas de Barbear, Aparelhos de Barbear e Isqueiros de Bolso a Gás não recarregáveis"                                                             
    ' "15"    "Lâmpadas Elétricas e Eletrônicas, Reatores e Starters"                                                                                             
    ' "16"    "Marketing Porta­a­Porta"                                                                                                                           
    ' "17"    "Massas Alimentícias, Biscoitos, Bolachas, Bolos, Pães, e outros derivados da farinha de trigo"                                                     
    ' "18"    "Materiais de Construção, Acabamentos, Bricolagens ou Adornos"                                                                                      
    ' "19"    "Materiais de Limpeza"                                                                                                                              
    ' "46"    "Material Elétrico"                                                                                                                                 
    ' "69"    "Motocicletas e ciclomotores"                                                                                                                       
    ' "45"    "Máquinas e Aparelhos Mecânicos, Elétricos, Eletromecânicos e Automáticos"                                                                          
    ' "65"    "Outros Produtos do Convênio ICMS 110/2007 (Aditivos, fluídos, aguarrás, etc)"                                                                      
    ' "60"    "Óleo Combustível"                                                                                                                                  
    ' "61"    "Óleo de Xisto"                                                                                                                                     
    ' "54"    "Óleo Diesel A (sem biodiesel ­ B100)"                                                                                                              
    ' "55"    "Óleo Diesel B (sem biodiesel ­ B100)"                                                                                                              
    ' "35"    "Pecuária"                                                                                                                                          
    ' "20"    "Peças, Partes, Componentes, Acessórios e demais produtos para Autopropulsados"                                                                     
    ' "21"    "Pilhas, Baterias Elétricas e Acumuladores Elétricos"                                                                                               
    ' "22"    "Pneumáticos, Câmaras de ar e Protetores"                                                                                                           
    ' "68"    "Produtos alimentícios"                                                                                                                             
    ' "58"    "Produtos Asfálticos"                                                                                                                               
    ' "76"    "Produtos Cerâmicos de uso na construção civil (utilizando argila ou barro cozido)"                                                                 
    ' "23"    "Produtos Farmacêuticos"                                                                                                                            
    ' "83"    "Provisionamento conforme conv. 110/2007"                                                                                                           
    ' "56"    "Querosene de Aviação"                                                                                                                              
    ' "57"    "Querosene Iluminante"                                                                                                                              
    ' "57"    "Querosene Iluminante"                                                                                                                              
    ' "24"    "Rações tipo pet para animais domésticos"                                                                                                           
    ' "80"    "Salgados Industrializados"                                                                                                                         
    ' "25"    "Sorvetes e Preparados para fabricação de sorvete em máquina"                                                                                       
    ' "26"    "Suportes Elásticos para cama, Colchões (inclusive Box), Travesseiros e Pillows"                                                                    
    ' "82"    "Telecomunicações"                                                                                                                                  
    ' "32"    "Telhas, cumeeira e caixas d agua de cimento, amianto, fibrocimento, polietilieno e fibra de vidro, inclusive suas tampas"                          
    ' "27"    "Tintas, Vernizes e outras mercadorias da indústria química"                                                                                        
    ' "37"    "Transporte"                                                                                                                                        
    ' "28"    "Trigo, Farinha de Trigo e Mistura de Farinha de Trigo"                                                                                             
    ' "29"    "Veículos Automotores Novos de 4 rodas"                                                                                                             
    ' "30"    "Veículos Automotores Novos Faturamento Direto para o Consumidor"                                                                                   
    ' "31"    "Veículos de Duas Rodas Motorizados"                                                                                                                
    '*******************************************************************************************************************************************************
End Module
