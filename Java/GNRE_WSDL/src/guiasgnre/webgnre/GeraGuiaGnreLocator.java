/**
 * GeraGuiaGnreLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package guiasgnre.webgnre;

public class GeraGuiaGnreLocator extends org.apache.axis.client.Service implements guiasgnre.webgnre.GeraGuiaGnre {

/**
 * O portal GuiasGNRE.com.br oferece a possibilidade de gerar suas
 * guias de recolhimento de tributos estaduais para todos os Estados
 * que disponibilizaram portais para emissão e validação das guias. Através
 * do portal GuiasGNRE.com.br você gera em um só lugar suas guias DIFAL,
 * FCOP e ICMS ST de forma rápida, e prática, através das informações
 * contidas nos XML's de suas notas fiscais.Lista de códigos de retorno
 * para as funções chamadas: 0 = Sucesso | 1 = Não autorizado, Verifique
 * o CNPJ, Usuário e Token. | 2 = Lote processado com pendências. | 3
 * = Nenhuma guia liberada no momento. | 4 = Falha ao buscar guias. |
 * 5 = Falha ao gerar o PDF. | 6 = Data inicial inválida. Padrão esperado:
 * AAAA-MM-DD. | 7 = Data final inválida. Padrão esperado: AAAA-MM-DD.
 */

    public GeraGuiaGnreLocator() {
    }


    public GeraGuiaGnreLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GeraGuiaGnreLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GeraGuiaGnreSoap
    private java.lang.String GeraGuiaGnreSoap_address = "https://www.guiasgnre.com.br/webgnre/GeraGuiaGnre.wso";

    public java.lang.String getGeraGuiaGnreSoapAddress() {
        return GeraGuiaGnreSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GeraGuiaGnreSoapWSDDServiceName = "GeraGuiaGnreSoap";

    public java.lang.String getGeraGuiaGnreSoapWSDDServiceName() {
        return GeraGuiaGnreSoapWSDDServiceName;
    }

    public void setGeraGuiaGnreSoapWSDDServiceName(java.lang.String name) {
        GeraGuiaGnreSoapWSDDServiceName = name;
    }

    public guiasgnre.webgnre.GeraGuiaGnreSoapType getGeraGuiaGnreSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GeraGuiaGnreSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGeraGuiaGnreSoap(endpoint);
    }

    public guiasgnre.webgnre.GeraGuiaGnreSoapType getGeraGuiaGnreSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            guiasgnre.webgnre.GeraGuiaGnreSoapBindingStub _stub = new guiasgnre.webgnre.GeraGuiaGnreSoapBindingStub(portAddress, this);
            _stub.setPortName(getGeraGuiaGnreSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGeraGuiaGnreSoapEndpointAddress(java.lang.String address) {
        GeraGuiaGnreSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (guiasgnre.webgnre.GeraGuiaGnreSoapType.class.isAssignableFrom(serviceEndpointInterface)) {
                guiasgnre.webgnre.GeraGuiaGnreSoapBindingStub _stub = new guiasgnre.webgnre.GeraGuiaGnreSoapBindingStub(new java.net.URL(GeraGuiaGnreSoap_address), this);
                _stub.setPortName(getGeraGuiaGnreSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GeraGuiaGnreSoap".equals(inputPortName)) {
            return getGeraGuiaGnreSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://guiasgnre/webgnre", "GeraGuiaGnre");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "GeraGuiaGnreSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GeraGuiaGnreSoap".equals(portName)) {
            setGeraGuiaGnreSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
