/**
 * TReciboNota.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package guiasgnre.webgnre;

public class TReciboNota  implements java.io.Serializable {
    private java.lang.String emitente;

    private int num_nota_fiscal;

    private java.lang.String modelo;

    private java.lang.String serie;

    private java.lang.String emissao_nf;

    private java.lang.String receita;

    private java.lang.String status;

    private java.lang.String recibo;

    private java.lang.String data_recibo;

    public TReciboNota() {
    }

    public TReciboNota(
           java.lang.String emitente,
           int num_nota_fiscal,
           java.lang.String modelo,
           java.lang.String serie,
           java.lang.String emissao_nf,
           java.lang.String receita,
           java.lang.String status,
           java.lang.String recibo,
           java.lang.String data_recibo) {
           this.emitente = emitente;
           this.num_nota_fiscal = num_nota_fiscal;
           this.modelo = modelo;
           this.serie = serie;
           this.emissao_nf = emissao_nf;
           this.receita = receita;
           this.status = status;
           this.recibo = recibo;
           this.data_recibo = data_recibo;
    }


    /**
     * Gets the emitente value for this TReciboNota.
     * 
     * @return emitente
     */
    public java.lang.String getEmitente() {
        return emitente;
    }


    /**
     * Sets the emitente value for this TReciboNota.
     * 
     * @param emitente
     */
    public void setEmitente(java.lang.String emitente) {
        this.emitente = emitente;
    }


    /**
     * Gets the num_nota_fiscal value for this TReciboNota.
     * 
     * @return num_nota_fiscal
     */
    public int getNum_nota_fiscal() {
        return num_nota_fiscal;
    }


    /**
     * Sets the num_nota_fiscal value for this TReciboNota.
     * 
     * @param num_nota_fiscal
     */
    public void setNum_nota_fiscal(int num_nota_fiscal) {
        this.num_nota_fiscal = num_nota_fiscal;
    }


    /**
     * Gets the modelo value for this TReciboNota.
     * 
     * @return modelo
     */
    public java.lang.String getModelo() {
        return modelo;
    }


    /**
     * Sets the modelo value for this TReciboNota.
     * 
     * @param modelo
     */
    public void setModelo(java.lang.String modelo) {
        this.modelo = modelo;
    }


    /**
     * Gets the serie value for this TReciboNota.
     * 
     * @return serie
     */
    public java.lang.String getSerie() {
        return serie;
    }


    /**
     * Sets the serie value for this TReciboNota.
     * 
     * @param serie
     */
    public void setSerie(java.lang.String serie) {
        this.serie = serie;
    }


    /**
     * Gets the emissao_nf value for this TReciboNota.
     * 
     * @return emissao_nf
     */
    public java.lang.String getEmissao_nf() {
        return emissao_nf;
    }


    /**
     * Sets the emissao_nf value for this TReciboNota.
     * 
     * @param emissao_nf
     */
    public void setEmissao_nf(java.lang.String emissao_nf) {
        this.emissao_nf = emissao_nf;
    }


    /**
     * Gets the receita value for this TReciboNota.
     * 
     * @return receita
     */
    public java.lang.String getReceita() {
        return receita;
    }


    /**
     * Sets the receita value for this TReciboNota.
     * 
     * @param receita
     */
    public void setReceita(java.lang.String receita) {
        this.receita = receita;
    }


    /**
     * Gets the status value for this TReciboNota.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this TReciboNota.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the recibo value for this TReciboNota.
     * 
     * @return recibo
     */
    public java.lang.String getRecibo() {
        return recibo;
    }


    /**
     * Sets the recibo value for this TReciboNota.
     * 
     * @param recibo
     */
    public void setRecibo(java.lang.String recibo) {
        this.recibo = recibo;
    }


    /**
     * Gets the data_recibo value for this TReciboNota.
     * 
     * @return data_recibo
     */
    public java.lang.String getData_recibo() {
        return data_recibo;
    }


    /**
     * Sets the data_recibo value for this TReciboNota.
     * 
     * @param data_recibo
     */
    public void setData_recibo(java.lang.String data_recibo) {
        this.data_recibo = data_recibo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TReciboNota)) return false;
        TReciboNota other = (TReciboNota) obj;
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
            this.num_nota_fiscal == other.getNum_nota_fiscal() &&
            ((this.modelo==null && other.getModelo()==null) || 
             (this.modelo!=null &&
              this.modelo.equals(other.getModelo()))) &&
            ((this.serie==null && other.getSerie()==null) || 
             (this.serie!=null &&
              this.serie.equals(other.getSerie()))) &&
            ((this.emissao_nf==null && other.getEmissao_nf()==null) || 
             (this.emissao_nf!=null &&
              this.emissao_nf.equals(other.getEmissao_nf()))) &&
            ((this.receita==null && other.getReceita()==null) || 
             (this.receita!=null &&
              this.receita.equals(other.getReceita()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.recibo==null && other.getRecibo()==null) || 
             (this.recibo!=null &&
              this.recibo.equals(other.getRecibo()))) &&
            ((this.data_recibo==null && other.getData_recibo()==null) || 
             (this.data_recibo!=null &&
              this.data_recibo.equals(other.getData_recibo())));
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
        _hashCode += getNum_nota_fiscal();
        if (getModelo() != null) {
            _hashCode += getModelo().hashCode();
        }
        if (getSerie() != null) {
            _hashCode += getSerie().hashCode();
        }
        if (getEmissao_nf() != null) {
            _hashCode += getEmissao_nf().hashCode();
        }
        if (getReceita() != null) {
            _hashCode += getReceita().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getRecibo() != null) {
            _hashCode += getRecibo().hashCode();
        }
        if (getData_recibo() != null) {
            _hashCode += getData_recibo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TReciboNota.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "tReciboNota"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emitente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "emitente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("num_nota_fiscal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "num_nota_fiscal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modelo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "modelo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "serie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emissao_nf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "emissao_nf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "receita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recibo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "recibo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data_recibo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://guiasgnre/webgnre", "data_recibo"));
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
