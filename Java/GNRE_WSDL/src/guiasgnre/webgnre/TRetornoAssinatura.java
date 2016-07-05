/**
 * TRetornoAssinatura.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package guiasgnre.webgnre;

public class TRetornoAssinatura  implements java.io.Serializable {
    private java.lang.String login;

    private java.lang.String razao;

    private java.lang.String CNPJ;

    private java.lang.String tokenAPI;

    private int retorno;

    private java.lang.String msg_retorno;

    public TRetornoAssinatura() {
    }

    public TRetornoAssinatura(
           java.lang.String login,
           java.lang.String razao,
           java.lang.String CNPJ,
           java.lang.String tokenAPI,
           int retorno,
           java.lang.String msg_retorno) {
           this.login = login;
           this.razao = razao;
           this.CNPJ = CNPJ;
           this.tokenAPI = tokenAPI;
           this.retorno = retorno;
           this.msg_retorno = msg_retorno;
    }


    /**
     * Gets the login value for this TRetornoAssinatura.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this TRetornoAssinatura.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the razao value for this TRetornoAssinatura.
     * 
     * @return razao
     */
    public java.lang.String getRazao() {
        return razao;
    }


    /**
     * Sets the razao value for this TRetornoAssinatura.
     * 
     * @param razao
     */
    public void setRazao(java.lang.String razao) {
        this.razao = razao;
    }


    /**
     * Gets the CNPJ value for this TRetornoAssinatura.
     * 
     * @return CNPJ
     */
    public java.lang.String getCNPJ() {
        return CNPJ;
    }


    /**
     * Sets the CNPJ value for this TRetornoAssinatura.
     * 
     * @param CNPJ
     */
    public void setCNPJ(java.lang.String CNPJ) {
        this.CNPJ = CNPJ;
    }


    /**
     * Gets the tokenAPI value for this TRetornoAssinatura.
     * 
     * @return tokenAPI
     */
    public java.lang.String getTokenAPI() {
        return tokenAPI;
    }


    /**
     * Sets the tokenAPI value for this TRetornoAssinatura.
     * 
     * @param tokenAPI
     */
    public void setTokenAPI(java.lang.String tokenAPI) {
        this.tokenAPI = tokenAPI;
    }


    /**
     * Gets the retorno value for this TRetornoAssinatura.
     * 
     * @return retorno
     */
    public int getRetorno() {
        return retorno;
    }


    /**
     * Sets the retorno value for this TRetornoAssinatura.
     * 
     * @param retorno
     */
    public void setRetorno(int retorno) {
        this.retorno = retorno;
    }


    /**
     * Gets the msg_retorno value for this TRetornoAssinatura.
     * 
     * @return msg_retorno
     */
    public java.lang.String getMsg_retorno() {
        return msg_retorno;
    }


    /**
     * Sets the msg_retorno value for this TRetornoAssinatura.
     * 
     * @param msg_retorno
     */
    public void setMsg_retorno(java.lang.String msg_retorno) {
        this.msg_retorno = msg_retorno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TRetornoAssinatura)) return false;
        TRetornoAssinatura other = (TRetornoAssinatura) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.razao==null && other.getRazao()==null) || 
             (this.razao!=null &&
              this.razao.equals(other.getRazao()))) &&
            ((this.CNPJ==null && other.getCNPJ()==null) || 
             (this.CNPJ!=null &&
              this.CNPJ.equals(other.getCNPJ()))) &&
            ((this.tokenAPI==null && other.getTokenAPI()==null) || 
             (this.tokenAPI!=null &&
              this.tokenAPI.equals(other.getTokenAPI()))) &&
            this.retorno == other.getRetorno() &&
            ((this.msg_retorno==null && other.getMsg_retorno()==null) || 
             (this.msg_retorno!=null &&
              this.msg_retorno.equals(other.getMsg_retorno())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getRazao() != null) {
            _hashCode += getRazao().hashCode();
        }
        if (getCNPJ() != null) {
            _hashCode += getCNPJ().hashCode();
        }
        if (getTokenAPI() != null) {
            _hashCode += getTokenAPI().hashCode();
        }
        _hashCode += getRetorno();
        if (getMsg_retorno() != null) {
            _hashCode += getMsg_retorno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TRetornoAssinatura.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoAssinatura"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "Login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "Razao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CNPJ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "CNPJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tokenAPI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "TokenAPI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "Retorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msg_retorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "Msg_retorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
