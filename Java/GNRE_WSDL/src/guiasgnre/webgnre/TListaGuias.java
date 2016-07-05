/**
 * TListaGuias.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package guiasgnre.webgnre;

public class TListaGuias  implements java.io.Serializable {
    private guiasgnre.webgnre.TGuias[] guias;

    private int retorno;

    private java.lang.String msg_retorno;

    public TListaGuias() {
    }

    public TListaGuias(
           guiasgnre.webgnre.TGuias[] guias,
           int retorno,
           java.lang.String msg_retorno) {
           this.guias = guias;
           this.retorno = retorno;
           this.msg_retorno = msg_retorno;
    }


    /**
     * Gets the guias value for this TListaGuias.
     * 
     * @return guias
     */
    public guiasgnre.webgnre.TGuias[] getGuias() {
        return guias;
    }


    /**
     * Sets the guias value for this TListaGuias.
     * 
     * @param guias
     */
    public void setGuias(guiasgnre.webgnre.TGuias[] guias) {
        this.guias = guias;
    }


    /**
     * Gets the retorno value for this TListaGuias.
     * 
     * @return retorno
     */
    public int getRetorno() {
        return retorno;
    }


    /**
     * Sets the retorno value for this TListaGuias.
     * 
     * @param retorno
     */
    public void setRetorno(int retorno) {
        this.retorno = retorno;
    }


    /**
     * Gets the msg_retorno value for this TListaGuias.
     * 
     * @return msg_retorno
     */
    public java.lang.String getMsg_retorno() {
        return msg_retorno;
    }


    /**
     * Sets the msg_retorno value for this TListaGuias.
     * 
     * @param msg_retorno
     */
    public void setMsg_retorno(java.lang.String msg_retorno) {
        this.msg_retorno = msg_retorno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TListaGuias)) return false;
        TListaGuias other = (TListaGuias) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.guias==null && other.getGuias()==null) || 
             (this.guias!=null &&
              java.util.Arrays.equals(this.guias, other.getGuias()))) &&
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
        if (getGuias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGuias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGuias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(TListaGuias.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tListaGuias"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "guias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tGuias"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tGuias"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "retorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msg_retorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "msg_retorno"));
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
