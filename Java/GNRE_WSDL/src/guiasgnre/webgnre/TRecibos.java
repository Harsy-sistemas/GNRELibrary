/**
 * TRecibos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package guiasgnre.webgnre;

public class TRecibos  implements java.io.Serializable {
    private java.lang.String emitente;

    private java.lang.String[] recibo;

    public TRecibos() {
    }

    public TRecibos(
           java.lang.String emitente,
           java.lang.String[] recibo) {
           this.emitente = emitente;
           this.recibo = recibo;
    }


    /**
     * Gets the emitente value for this TRecibos.
     * 
     * @return emitente
     */
    public java.lang.String getEmitente() {
        return emitente;
    }


    /**
     * Sets the emitente value for this TRecibos.
     * 
     * @param emitente
     */
    public void setEmitente(java.lang.String emitente) {
        this.emitente = emitente;
    }


    /**
     * Gets the recibo value for this TRecibos.
     * 
     * @return recibo
     */
    public java.lang.String[] getRecibo() {
        return recibo;
    }


    /**
     * Sets the recibo value for this TRecibos.
     * 
     * @param recibo
     */
    public void setRecibo(java.lang.String[] recibo) {
        this.recibo = recibo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TRecibos)) return false;
        TRecibos other = (TRecibos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.emitente==null && other.getEmitente()==null) || 
             (this.emitente!=null &&
              this.emitente.equals(other.getEmitente()))) &&
            ((this.recibo==null && other.getRecibo()==null) || 
             (this.recibo!=null &&
              java.util.Arrays.equals(this.recibo, other.getRecibo())));
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
        if (getEmitente() != null) {
            _hashCode += getEmitente().hashCode();
        }
        if (getRecibo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRecibo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRecibo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TRecibos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRecibos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emitente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "emitente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recibo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "recibo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "string"));
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
