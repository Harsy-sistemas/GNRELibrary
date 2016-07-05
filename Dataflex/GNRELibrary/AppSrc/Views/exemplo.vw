Use Windows.pkg
Use DFClient.pkg
Use Pacotes\GGGCriaAssinatura_Gratis.pkg

Deferred_View Activate_oExemplo for ;
Object oExemplo is a dbView

    Set Border_Style to Border_Thick
    // DataFlex 18.2 Client Size Adjuster, modified April 22, 2016: 10:50:12
//    Set Size to 305 419
    Set Size to 295 247
    Set Location to 6 7
    Set Label to "Exemplo da fun‡Æo GGGCriaAssinatura_Gratis"

    Object oUsuario is a Form
        Set Size to 13 200
        Set Location to 14 9
        Set Label to "Nome do Respons vel pela Assinatura:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oLogin is a Form
        Set Size to 13 200
        Set Location to 38 9
        Set Label to "Login (endere‡o de e-mail para acesso ao portal):"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oSenha is a Form
        Set Size to 13 200
        Set Location to 62 9
        Set Label to "Senha para acesso ao portal:"
        //Set peAnchors to anAll
        Set FontWeight to 600    
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oRazao is a Form
        Set Size to 13 200
        Set Location to 86 9
        Set Label to "RazÆo Social da Empresa:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oFantasia is a Form
        Set Size to 13 200
        Set Location to 110 9
        Set Label to "Nome Fantasia:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object otelefone is a Form
        Set Size to 13 91
        Set Location to 134 9
        Set Label to "Telefone de Contato da Empresa:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oCEP is a Form
        Set Size to 13 91
        Set Location to 134 134
        Set Label to "CEP da Empresa:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oLogradouro is a Form
        Set Size to 13 200
        Set Location to 158 9
        Set Label to "Logradouro da Empresa:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object


    Object oNumero is a Form
        Set Size to 13 91
        Set Location to 182 9
        Set Label to "N£mero:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object


    Object oComplemento is a Form
        Set Size to 13 91
        Set Location to 182 134
        Set Label to "Complemento:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oBairro is a Form
        Set Size to 13 200
        Set Location to 206 9
        Set Label to "Bairro:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oUf is a Form
        Set Size to 13 91
        Set Location to 230 9
        Set Label to "C¢digo IBGE ou Sigla da UF:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Capslock_State to True
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oCidade is a Form
        Set Size to 13 91
        Set Location to 230 134
        Set Label to "C¢digo IBGE da Cidade:"
        //Set peAnchors to anAll
        Set FontWeight to 600
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object

    Object oCNPJ is a Form
        Set Size to 13 91
        Set Location to 254 9
        Set Label to "CNPJ da Empresa:"
        //Set peAnchors to anAll
        Set FontWeight to 600    
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object


    Object oButton1 is a Button
        Set Location to 254 134
        Set Label to "Criar conta"
    
        // fires when the button is clicked
        Procedure OnClick
            tWStAssinatura Assinatura
            tWStRetornoAssinatura RetornoAssinatura
            
            Get value of oLogin         to Assinatura.Login
            Get value of oSenha         to Assinatura.Senha
            Get value of oRazao         to Assinatura.Razao
            Get value of ofantasia      to Assinatura.Fantasia
            Get value of otelefone      to Assinatura.Telefone
            Get value of oCep           to Assinatura.Cep
            Get value of oLogradouro    to Assinatura.Logradouro
            Get value of oNumero        to Assinatura.Nro
            Get value of oComplemento   to Assinatura.Complemento
            Get value of oBairro        to Assinatura.Bairro
            Get value of oCidade        to Assinatura.Codigo_Cidade
            Get value of oUf            to Assinatura.Codigo_UF
            Get value of oCNPJ          to Assinatura.CNPJ
            Get value of oUsuario       to Assinatura.Nome
            
            Get GGGCriaAssinatura_Gratis Assinatura to RetornoAssinatura
            
            If (RetornoAssinatura.Retorno > 0);
            Begin
                Send Info_Box ("C¢digo do erro: " + (RetornoAssinatura.Retorno) + "\nDescri‡Æo: " + (RetornoAssinatura.Msg_retorno)) "Falha na cria‡Æo da conta"
            End
            Else Begin
                // grave o sToken ou guarde para utilizar com as outras fun‡äes.
                // Se precisar consultar o token gerado entre em https://www.guiasgnre.com.br/webgnre
                Send Info_Box ("Seu Token de acesso a API: " + (RetornoAssinatura.TokenAPI)) 'Assinatura criada com sucesso.' 
                Set Value of oToken to (RetornoAssinatura.TokenAPI)
            End
                        
        End_Procedure
    
    End_Object

    Object oToken is a Form
        Set Size to 13 231
        Set Location to 278 9
        Set Label to "Token API:"
        Set Label_Col_Offset to 0
        Set Label_Justification_Mode to JMode_Top
    End_Object


Cd_End_Object

