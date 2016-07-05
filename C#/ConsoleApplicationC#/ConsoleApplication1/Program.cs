using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.IO;

namespace ConsoleApplication1
{
    class Program
    {      
        static void Main(string[] args)
        {
            // Estrutura/Container de notas
            WebReference.tListaNfe ListaNfe = new WebReference.tListaNfe();
            
            // Array com a Lista de notas (apenas 2 para testes)
            ListaNfe.itens = new WebReference.tDadosNfe[2];
            // Descrição dos campos da estrutura tDadosNfe: 
            // emitente = CNPJ da empresa emitente da nota
            // serie = Série da NF
            // modelo = Modelo do documento (NF-e = 55)
            // num_nota_fiscal = Número da nota fiscal
            // tipo_documento = Mantenha sempre o código 10 neste campo (Uso interno)
            // chave_nfe = Chave de acesso da NF-e
            // convenio = Deixar em branco (Uso interno)
            // data_emissao = Data de emissão da nota fiscal - Formato: "2016-05-25" 
            // produto = Deixar em branco. Caso a UF de destino seja RJ, colocar 698. Caso a SEFAZ de 
            //           destino exija a informação do produto, analisar lista de códigos e correspondência 
            //           dos produtos no final deste arquivo para passar no próximo envio desta nota.
            // vencimento = Deixar em branco (Uso interno)
            // valor = Valor da nota fiscal
            // icms_uf_destino = Valor do ICMS partilhado da UF de destino
            // fcp_uf_destino = Valor do Fundo de Combate a Pobreza a ser pago a UF de destino (se houver)
            // cnpj = CNPJ do destinatário. Deixar em branco se for pessoa física e informar somente o CPF abaixo.
            // cpf = CPF do destinatário. Deixar em branco se for pessoa jurídica e informar somente o CNPJ acima.
            // nome_destinatario = Nome/razão do destinatário.
            // municipio_destinatario = Município do destinatário.
            // cod_municipio_destinat = Código IBGE do município.
            // uf_destinatario = Sigla da UF de destino.
            // data_recepcao = Deixar em branco (Uso interno)

            // Manipulador do serviço
            WebReference.GeraGuiaGnre sServico = new WebReference.GeraGuiaGnre();

            // Primeiro exemplo: Enviando lote de notas para que sejam geradas as respectivas guias.
            // Lista de notas para geração de guias.
            ListaNfe.itens[0] = new WebReference.tDadosNfe {emitente = "09141415000150", serie = "000", modelo = "55", num_nota_fiscal = 1577, tipo_documento = "10", chave_nfe = "35160509141415000150550000000015771000015775", data_emissao = "2016-05-25", vencimento = "", valor = (Convert.ToDecimal("101,82")), icms_uf_destino = (Convert.ToDecimal("1,90")), fcp_uf_destino = 0, cpf = "10618969861", nome_destinatario = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL", municipio_destinatario = "PORTO ALEGRE", cod_municipio_destinat = "14902", uf_destinatario = "RS", convenio = "", cnpj = "", data_recepcao = "", produto = "" };
            ListaNfe.itens[1] = new WebReference.tDadosNfe {emitente = "09141415000150", serie = "000", modelo = "55", num_nota_fiscal = 1578, tipo_documento = "10", chave_nfe = "35160509141415000150550000000015781000015780", data_emissao = "2016-05-25", vencimento = "", valor = (Convert.ToDecimal("7704,00")), icms_uf_destino = (Convert.ToDecimal("201,60")), fcp_uf_destino = 0, cpf = "10618969861", nome_destinatario = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL", municipio_destinatario = "BELEM", cod_municipio_destinat = "01402", uf_destinatario = "PA", convenio = "", cnpj = "", data_recepcao = "", produto = "698" };


            // Chamada ao serviço. RetornoLote recebe o retorno do serviço com o código do resultado no campo 'RetornoLote.retorno', 
            // a descrição deste código e detalhes da operação em 'RetornoLote.msg_resultado' e os detalhes do recibo do envio dentro 
            // do array 'RetornoLote.recibos'.

            // Descrição dos parâmetros a serem passados: 
            // sEmpresa  = CNPJ da empresa emitente das notas, cadastrada no portal.
            // sUsuario  = Seu endereço de e-mail cadastrado no portal GuiasGNRE.
            // sChaveApi = Sua chave de acesso a API, exibida ao clicar no botão "Cadastro", no portal.
            WebReference.tRetornoLote Lote = sServico.GeraGuia("09141415000150", "seu.email.cadastrado.no.portal@dominio.com.br", "XXXXX", ListaNfe);

            // Buscando as guias geradas pela chamada anterior, recebendo a lista de guias para serem usadas como quiser, 
            // seja sendo impressas em um sistema gerador de relatórios, exportadas para um outro sistema, etc.
            // Aqui, não faremos nada com essa lista, é apenas para fins didáticos.
            WebReference.tListaGuias ListaGuias = sServico.BuscaGuia("09141415000150", "seu.email.cadastrado.no.portal@dominio.com.br", "XXXXX", Lote);

            // Agora, usando o mesmo lote de recibos que nos trouxeram a lista de guias na chamada acima, 
            // vamos buscar essas guias novamente, mas trazendo o PDF destas guias (as que estiverem liberadas apenas).
            WebReference.tRetornoLotePDF PdfGuias1 = sServico.BuscaGuiaPDF("09141415000150", "seu.email.cadastrado.no.portal@dominio.com.br", "XXXXX", Lote);

            byte[] aByte = PdfGuias1.pdf_guias[0].pdf.Cast<byte>().ToArray();

            if (aByte.Length > 0)
            {
                BinaryWriter Writer = new BinaryWriter(File.OpenWrite("C:\\Temp\\" + PdfGuias1.pdf_guias[0].nome + ".pdf"));
                Writer.Write(aByte);
                Writer.Flush();
                Writer.Close();
            }

            aByte = null;


            // Depois de testar a geração das guias, a consulta a estas guias, e a recepção destas
            // guias como PDF, temos abaixo um exemplo de como gerar e receber o PDF das guias em uma única chamada.
            // Esse é processo mais demorado que os anteriores, pois temos a junção de duas funções anteriores
            // (envio das notas e geração das guias, e busca das guias e retorno em PDF) em uma só.
            // Esta função, devido a demora no processamento, recomendamos que seja usada apenas para uma
            // pequena quantidade de guias.

            // Geração das guias para as notas fiscais 20982 e 20983, recebendo o retorno das guias em PDF.
            ListaNfe.itens[0] = new WebReference.tDadosNfe {emitente = "09141415000150", serie = "000", modelo = "55", num_nota_fiscal = 1576, tipo_documento = "10", chave_nfe = "35160509141415000150550000000015761000015760", data_emissao = "2016-05-25", vencimento = "", valor = (Convert.ToDecimal("4959,45")), icms_uf_destino = (Convert.ToDecimal("92,70")), fcp_uf_destino = 0, cpf = "10618969861", nome_destinatario = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL", municipio_destinatario = "PORTO ALEGRE", cod_municipio_destinat = "14902", uf_destinatario = "RS", convenio = "", cnpj = "", data_recepcao = "", produto = ""};
            ListaNfe.itens[1] = new WebReference.tDadosNfe {emitente = "09141415000150", serie = "000", modelo = "55", num_nota_fiscal = 1579, tipo_documento = "10", chave_nfe = "35160509141415000150550000000015791000015796", data_emissao = "2016-05-25", vencimento = "", valor = (Convert.ToDecimal("1829,60")), icms_uf_destino = (Convert.ToDecimal("68,40")), fcp_uf_destino = 0, cpf = "10618969861", nome_destinatario = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL", municipio_destinatario = "BELEM", cod_municipio_destinat = "01402", uf_destinatario = "PA", convenio = "", cnpj = "", data_recepcao = "", produto = "" };

            // Descrição dos parâmetros a serem passados: 
            // sEmpresa  = CNPJ da empresa emitente das notas, cadastrada no portal.
            // sUsuario  = Seu endereço de e-mail cadastrado no portal GuiasGNRE.
            // sChaveApi = Sua chave de acesso a API, exibida ao clicar no botão "Cadastro", no portal.
            WebReference.tRetornoLotePDF PdfGuias = sServico.GeraGuiaPDF ("09141415000150", "seu.email.cadastrado.no.portal@dominio.com.br", "XXXXX", ListaNfe);
            
            aByte = PdfGuias.pdf_guias[0].pdf.Cast<byte>().ToArray();

            if (aByte.Length > 0)
            {
                BinaryWriter Writer = new BinaryWriter(File.OpenWrite("C:\\Temp\\" + PdfGuias.pdf_guias[0].nome + ".pdf"));
                Writer.Write(aByte);
                Writer.Flush();
                Writer.Close();
            }

            //*******************************************************************************************************************************************************
            // Lista de Códigos de Produtos
            // Cód.:   Descrição:
            // "79"    "Açúcar de cana"                                                                                                                                    
            // "36"    "Agricultura"                                                                                                                                       
            // "1"     "Aguardente"                                                                                                                                        
            // "48"    "Álcool Etílico Anidro"                                                                                                                             
            // "49"    "Álcool Etílico Hidratado"                                                                                                                          
            // "2"     "Álcool Etílico Hidratado Combustível (AEHC) e Álcool para fins nãocombustíveis"                                                                    
            // "3"     "Aparelhos Celulares e Cartão Inteligente (Smart Cards e SimCard)"                                                                                  
            // "70"    "Aquisição de mercadorias de forma não presencial (internet, telemarketing e showroom)"                                                             
            // "43"    "Artefatos de Uso Doméstico"                                                                                                                        
            // "47"    "Artigos de Papelaria"                                                                                                                              
            // "4"     "Bebidas Alcoólicas (exceto Cervejas, Chopes e Aguardente)"                                                                                         
            // "81"    "Bebidas Quentes"                                                                                                                                   
            // "40"    "Bicicletas e Peças"                                                                                                                                
            // "50"    "Biodiesel B100"                                                                                                                                    
            // "44"    "Brinquedos"                                                                                                                                        
            // "71"    "Café Torrado e moído"                                                                                                                              
            // "72"    "Calçados"                                                                                                                                          
            // "5"     "Cervejas, Chopes, Refrigerantes, Água Mineral ou Potável, Bebidas Eletrolíticas (Isotônicas e Energéticas, nbm/sh 2106.90 e 2202.90) e Gelo"       
            // "73"    "Chocolates e preparações similares"                                                                                                                
            // "6"     "Cigarros e produtos derivados Do fumo"                                                                                                             
            // "7"     "Cimento"                                                                                                                                           
            // "8"     "Combustíveis e Lubrificantes, derivados ou não de petróleo, Alcool Etílico Anidro Combustível (AEAC) e BIODIESEL B100"                             
            // "38"    "Comunicação"                                                                                                                                       
            // "33"    "Comércio Outros não especificados"                                                                                                                 
            // "59"    "Coque"                                                                                                                                             
            // "9"     "Cosméticos, Perfumaria, Artigos de Higiene Pessoal e de Toucador"                                                                                  
            // "66"    "Derivados de petróleo e demais combustíveis e lubrificantes ­ exceto alcool etílico anidro, alcool etílico hidratado (AEHC) e biodisel ­ B100"     
            // "10"    "Discos Fonográficos, Fitas Virgens ou Gravadas e Outros Suportes para Reprodução ou Gravação"                                                      
            // "11"    "Eletrodomésticos, Eletroeletrônicos e Equipamentos de Informática"                                                                                 
            // "39"    "Energia Elétrica"                                                                                                                                  
            // "78"    "Extrato concentrados destinado ao preparo de refrigerantes em máquinas (pré­mix e pós­mix)"                                                        
            // "41"    "Ferramentas"                                                                                                                                       
            // "12"    "Filmes Fotográficos e Cinematográficos e Slides"                                                                                                   
            // "13"    "Gado e Produtos Resultantes de seu abate Código Descrição"                                                                                         
            // "51"    "Gasolina A (sem álcool anidro ­ AEAC)"                                                                                                             
            // "52"    "Gasolina C (com álcool anidro ­ AEAC)"                                                                                                             
            // "53"    "Gasolina de Aviação"                                                                                                                               
            // "63"    "Gás Liquefeito de Petróleo ­ GLP"                                                                                                                  
            // "62"    "Gás Natural"                                                                                                                                       
            // "84"    "ICMS Complementar Conv. 110/2007"                                                                                                                  
            // "34"    "Indústria não especificados"                                                                                                                       
            // "42"    "Instrumentos Musicais"                                                                                                                             
            // "74"    "Iogurte"                                                                                                                                           
            // "77"    "Ladrilhos, placas p/pavimentação, cubos, pastilhas e azulejos"                                                                                     
            // "64"    "Lubrificantes"                                                                                                                                     
            // "75"    "Luvas Cirúrgicas e Luvas de Procedimentos"                                                                                                         
            // "14"    "Lâminas de Barbear, Aparelhos de Barbear e Isqueiros de Bolso a Gás não recarregáveis"                                                             
            // "15"    "Lâmpadas Elétricas e Eletrônicas, Reatores e Starters"                                                                                             
            // "16"    "Marketing Porta­a­Porta"                                                                                                                           
            // "17"    "Massas Alimentícias, Biscoitos, Bolachas, Bolos, Pães, e outros derivados da farinha de trigo"                                                     
            // "18"    "Materiais de Construção, Acabamentos, Bricolagens ou Adornos"                                                                                      
            // "19"    "Materiais de Limpeza"                                                                                                                              
            // "46"    "Material Elétrico"                                                                                                                                 
            // "69"    "Motocicletas e ciclomotores"                                                                                                                       
            // "45"    "Máquinas e Aparelhos Mecânicos, Elétricos, Eletromecânicos e Automáticos"                                                                          
            // "65"    "Outros Produtos do Convênio ICMS 110/2007 (Aditivos, fluídos, aguarrás, etc)"                                                                      
            // "60"    "Óleo Combustível"                                                                                                                                  
            // "61"    "Óleo de Xisto"                                                                                                                                     
            // "54"    "Óleo Diesel A (sem biodiesel ­ B100)"                                                                                                              
            // "55"    "Óleo Diesel B (sem biodiesel ­ B100)"                                                                                                              
            // "35"    "Pecuária"                                                                                                                                          
            // "20"    "Peças, Partes, Componentes, Acessórios e demais produtos para Autopropulsados"                                                                     
            // "21"    "Pilhas, Baterias Elétricas e Acumuladores Elétricos"                                                                                               
            // "22"    "Pneumáticos, Câmaras de ar e Protetores"                                                                                                           
            // "68"    "Produtos alimentícios"                                                                                                                             
            // "58"    "Produtos Asfálticos"                                                                                                                               
            // "76"    "Produtos Cerâmicos de uso na construção civil (utilizando argila ou barro cozido)"                                                                 
            // "23"    "Produtos Farmacêuticos"                                                                                                                            
            // "83"    "Provisionamento conforme conv. 110/2007"                                                                                                           
            // "56"    "Querosene de Aviação"                                                                                                                              
            // "57"    "Querosene Iluminante"                                                                                                                              
            // "57"    "Querosene Iluminante"                                                                                                                              
            // "24"    "Rações tipo pet para animais domésticos"                                                                                                           
            // "80"    "Salgados Industrializados"                                                                                                                         
            // "25"    "Sorvetes e Preparados para fabricação de sorvete em máquina"                                                                                       
            // "26"    "Suportes Elásticos para cama, Colchões (inclusive Box), Travesseiros e Pillows"                                                                    
            // "82"    "Telecomunicações"                                                                                                                                  
            // "32"    "Telhas, cumeeira e caixas d agua de cimento, amianto, fibrocimento, polietilieno e fibra de vidro, inclusive suas tampas"                          
            // "27"    "Tintas, Vernizes e outras mercadorias da indústria química"                                                                                        
            // "37"    "Transporte"                                                                                                                                        
            // "28"    "Trigo, Farinha de Trigo e Mistura de Farinha de Trigo"                                                                                             
            // "29"    "Veículos Automotores Novos de 4 rodas"                                                                                                             
            // "30"    "Veículos Automotores Novos Faturamento Direto para o Consumidor"                                                                                   
            // "31"    "Veículos de Duas Rodas Motorizados"                                                                                                                
            //*******************************************************************************************************************************************************
        }
    }
}
