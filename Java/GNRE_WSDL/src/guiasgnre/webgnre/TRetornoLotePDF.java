/**
 * TRetornoLotePDF.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package guiasgnre.webgnre;

public class TRetornoLotePDF  implements java.io.Serializable {
    private int retorno;

    private java.lang.String msg_retorno;

    private int lote;

    private guiasgnre.webgnre.TPdfGuias[] pdf_guias;

    public TRetornoLotePDF() {
    }

    public TRetornoLotePDF(
           int retorno,
           java.lang.String msg_retorno,
           int lote,
           guiasgnre.webgnre.TPdfGuias[] pdf_guias) {
           this.retorno = retorno;
           this.msg_retorno = msg_retorno;
           this.lote = lote;
           this.pdf_guias = pdf_guias;
    }


    /**
     * Gets the retorno value for this TRetornoLotePDF.
     * 
     * @return retorno
     */
    public int getRetorno() {
        return retorno;
    }


    /**
     * Sets the retorno value for this TRetornoLotePDF.
     * 
     * @param retorno
     */
    public void setRetorno(int retorno) {
        this.retorno = retorno;
    }


    /**
     * Gets the msg_retorno value for this TRetornoLotePDF.
     * 
     * @return msg_retorno
     */
    public java.lang.String getMsg_retorno() {
        return msg_retorno;
    }


    /**
     * Sets the msg_retorno value for this TRetornoLotePDF.
     * 
     * @param msg_retorno
     */
    public void setMsg_retorno(java.lang.String msg_retorno) {
        this.msg_retorno = msg_retorno;
    }


    /**
     * Gets the lote value for this TRetornoLotePDF.
     * 
     * @return lote
     */
    public int getLote() {
        return lote;
    }


    /**
     * Sets the lote value for this TRetornoLotePDF.
     * 
     * @param lote
     */
    public void setLote(int lote) {
        this.lote = lote;
    }


    /**
     * Gets the pdf_guias value for this TRetornoLotePDF.
     * 
     * @return pdf_guias
     */
    public guiasgnre.webgnre.TPdfGuias[] getPdf_guias() {
        return pdf_guias;
    }


    /**
     * Sets the pdf_guias value for this TRetornoLotePDF.
     * 
     * @param pdf_guias
     */
    public void setPdf_guias(guiasgnre.webgnre.TPdfGuias[] pdf_guias) {
        this.pdf_guias = pdf_guias;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TRetornoLotePDF)) return false;
        TRetornoLotePDF other = (TRetornoLotePDF) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.retorno == other.getRetorno() &&
            ((this.msg_retorno==null && other.getMsg_retorno()==null) || 
             (this.msg_retorno!=null &&
              this.msg_retorno.equals(other.getMsg_retorno()))) &&
            this.lote == other.getLote() &&
            ((this.pdf_guias==null && other.getPdf_guias()==null) || 
             (this.pdf_guias!=null &&
              java.util.Arrays.equals(this.pdf_guias, other.getPdf_guias())));
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
        _hashCode += getRetorno();
        if (getMsg_retorno() != null) {
            _hashCode += getMsg_retorno().hashCode();
        }
        _hashCode += getLote();
        if (getPdf_guias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPdf_guias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPdf_guias(), i);
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
        new org.apache.axis.description.TypeDesc(TRetornoLotePDF.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tRetornoLotePDF"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lote");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "lote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pdf_guias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "pdf_guias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tPdfGuias"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tPdfGuias"));
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
