/**
 * GeraGuiaGnreSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package guiasgnre.webgnre;

public class GeraGuiaGnreSoapBindingStub extends org.apache.axis.client.Stub implements guiasgnre.webgnre.GeraGuiaGnreSoapType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[8];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GeraGuia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sEmpresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sChaveApi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "ListaNfe"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tListaNfe"), guiasgnre.webgnre.TListaNfe.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoLote"));
        oper.setReturnClass(guiasgnre.webgnre.TRetornoLote.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "GeraGuiaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GeraGuiaPDF");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sEmpresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sChaveApi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "ListaNfe"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tListaNfe"), guiasgnre.webgnre.TListaNfe.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoLotePDF"));
        oper.setReturnClass(guiasgnre.webgnre.TRetornoLotePDF.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "GeraGuiaPDFResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BuscaGuiasPendentes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sEmpresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sChaveApi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "GuiasPendentes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRecibos"), guiasgnre.webgnre.TRecibos.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tListaGuias"));
        oper.setReturnClass(guiasgnre.webgnre.TListaGuias.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaGuiasPendentesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BuscaTodasGuiasPendentes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sEmpresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sChaveApi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sDataInicio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sDataFim"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tListaGuias"));
        oper.setReturnClass(guiasgnre.webgnre.TListaGuias.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaTodasGuiasPendentesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BuscaTodasGuiasComErro");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sEmpresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sChaveApi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sDataInicio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sDataFim"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tListaGuias"));
        oper.setReturnClass(guiasgnre.webgnre.TListaGuias.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaTodasGuiasComErroResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BuscaGuia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sEmpresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sChaveApi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "Lote"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoLote"), guiasgnre.webgnre.TRetornoLote.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tListaGuias"));
        oper.setReturnClass(guiasgnre.webgnre.TListaGuias.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaGuiaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BuscaGuiaPDF");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sEmpresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "sChaveApi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "Lote"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoLote"), guiasgnre.webgnre.TRetornoLote.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoLotePDF"));
        oper.setReturnClass(guiasgnre.webgnre.TRetornoLotePDF.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaGuiaPDFResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Assinatura_gratis");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "Assinatura"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tAssinatura"), guiasgnre.webgnre.TAssinatura.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoAssinatura"));
        oper.setReturnClass(guiasgnre.webgnre.TRetornoAssinatura.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "Assinatura_gratisResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

    }

    public GeraGuiaGnreSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public GeraGuiaGnreSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public GeraGuiaGnreSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "ArrayOftDadosNfe");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TDadosNfe[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tDadosNfe");
            qName2 = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tDadosNfe");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "ArrayOftGuias");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TGuias[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tGuias");
            qName2 = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tGuias");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "ArrayOftPdfGuias");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TPdfGuias[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tPdfGuias");
            qName2 = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tPdfGuias");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "ArrayOftReciboNota");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TReciboNota[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tReciboNota");
            qName2 = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tReciboNota");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "ArrayOfUnsignedByte");
            cachedSerQNames.add(qName);
            cls = org.apache.axis.types.UnsignedByte[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte");
            qName2 = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "unsignedByte");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tAssinatura");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TAssinatura.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tDadosNfe");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TDadosNfe.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tGuias");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TGuias.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tListaGuias");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TListaGuias.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tListaNfe");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TListaNfe.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tPdfGuias");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TPdfGuias.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tReciboNota");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TReciboNota.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRecibos");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TRecibos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoAssinatura");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TRetornoAssinatura.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoLote");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TRetornoLote.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoLotePDF");
            cachedSerQNames.add(qName);
            cls = guiasgnre.webgnre.TRetornoLotePDF.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public guiasgnre.webgnre.TRetornoLote geraGuia(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TListaNfe listaNfe) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "GeraGuia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sEmpresa, sUsuario, sChaveApi, listaNfe});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (guiasgnre.webgnre.TRetornoLote) _resp;
            } catch (java.lang.Exception _exception) {
                return (guiasgnre.webgnre.TRetornoLote) org.apache.axis.utils.JavaUtils.convert(_resp, guiasgnre.webgnre.TRetornoLote.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public guiasgnre.webgnre.TRetornoLotePDF geraGuiaPDF(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TListaNfe listaNfe) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "GeraGuiaPDF"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sEmpresa, sUsuario, sChaveApi, listaNfe});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (guiasgnre.webgnre.TRetornoLotePDF) _resp;
            } catch (java.lang.Exception _exception) {
                return (guiasgnre.webgnre.TRetornoLotePDF) org.apache.axis.utils.JavaUtils.convert(_resp, guiasgnre.webgnre.TRetornoLotePDF.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public guiasgnre.webgnre.TListaGuias buscaGuiasPendentes(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TRecibos guiasPendentes) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaGuiasPendentes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sEmpresa, sUsuario, sChaveApi, guiasPendentes});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (guiasgnre.webgnre.TListaGuias) _resp;
            } catch (java.lang.Exception _exception) {
                return (guiasgnre.webgnre.TListaGuias) org.apache.axis.utils.JavaUtils.convert(_resp, guiasgnre.webgnre.TListaGuias.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public guiasgnre.webgnre.TListaGuias buscaTodasGuiasPendentes(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, java.lang.String sDataInicio, java.lang.String sDataFim) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaTodasGuiasPendentes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sEmpresa, sUsuario, sChaveApi, sDataInicio, sDataFim});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (guiasgnre.webgnre.TListaGuias) _resp;
            } catch (java.lang.Exception _exception) {
                return (guiasgnre.webgnre.TListaGuias) org.apache.axis.utils.JavaUtils.convert(_resp, guiasgnre.webgnre.TListaGuias.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public guiasgnre.webgnre.TListaGuias buscaTodasGuiasComErro(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, java.lang.String sDataInicio, java.lang.String sDataFim) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaTodasGuiasComErro"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sEmpresa, sUsuario, sChaveApi, sDataInicio, sDataFim});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (guiasgnre.webgnre.TListaGuias) _resp;
            } catch (java.lang.Exception _exception) {
                return (guiasgnre.webgnre.TListaGuias) org.apache.axis.utils.JavaUtils.convert(_resp, guiasgnre.webgnre.TListaGuias.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public guiasgnre.webgnre.TListaGuias buscaGuia(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TRetornoLote lote) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaGuia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sEmpresa, sUsuario, sChaveApi, lote});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (guiasgnre.webgnre.TListaGuias) _resp;
            } catch (java.lang.Exception _exception) {
                return (guiasgnre.webgnre.TListaGuias) org.apache.axis.utils.JavaUtils.convert(_resp, guiasgnre.webgnre.TListaGuias.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public guiasgnre.webgnre.TRetornoLotePDF buscaGuiaPDF(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TRetornoLote lote) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "BuscaGuiaPDF"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sEmpresa, sUsuario, sChaveApi, lote});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (guiasgnre.webgnre.TRetornoLotePDF) _resp;
            } catch (java.lang.Exception _exception) {
                return (guiasgnre.webgnre.TRetornoLotePDF) org.apache.axis.utils.JavaUtils.convert(_resp, guiasgnre.webgnre.TRetornoLotePDF.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public guiasgnre.webgnre.TRetornoAssinatura assinatura_gratis(guiasgnre.webgnre.TAssinatura assinatura) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "Assinatura_gratis"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {assinatura});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (guiasgnre.webgnre.TRetornoAssinatura) _resp;
            } catch (java.lang.Exception _exception) {
                return (guiasgnre.webgnre.TRetornoAssinatura) org.apache.axis.utils.JavaUtils.convert(_resp, guiasgnre.webgnre.TRetornoAssinatura.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
