package guiasgnre.webgnre;

public class GeraGuiaGnreSoapTypeProxy implements guiasgnre.webgnre.GeraGuiaGnreSoapType {
  private String _endpoint = null;
  private guiasgnre.webgnre.GeraGuiaGnreSoapType geraGuiaGnreSoapType = null;
  
  public GeraGuiaGnreSoapTypeProxy() {
    _initGeraGuiaGnreSoapTypeProxy();
  }
  
  public GeraGuiaGnreSoapTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initGeraGuiaGnreSoapTypeProxy();
  }
  
  private void _initGeraGuiaGnreSoapTypeProxy() {
    try {
      geraGuiaGnreSoapType = (new guiasgnre.webgnre.GeraGuiaGnreLocator()).getGeraGuiaGnreSoap();
      if (geraGuiaGnreSoapType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)geraGuiaGnreSoapType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)geraGuiaGnreSoapType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (geraGuiaGnreSoapType != null)
      ((javax.xml.rpc.Stub)geraGuiaGnreSoapType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public guiasgnre.webgnre.GeraGuiaGnreSoapType getGeraGuiaGnreSoapType() {
    if (geraGuiaGnreSoapType == null)
      _initGeraGuiaGnreSoapTypeProxy();
    return geraGuiaGnreSoapType;
  }
  
  public guiasgnre.webgnre.TRetornoLote geraGuia(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TListaNfe listaNfe) throws java.rmi.RemoteException{
    if (geraGuiaGnreSoapType == null)
      _initGeraGuiaGnreSoapTypeProxy();
    return geraGuiaGnreSoapType.geraGuia(sEmpresa, sUsuario, sChaveApi, listaNfe);
  }
  
  public guiasgnre.webgnre.TRetornoLotePDF geraGuiaPDF(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TListaNfe listaNfe) throws java.rmi.RemoteException{
    if (geraGuiaGnreSoapType == null)
      _initGeraGuiaGnreSoapTypeProxy();
    return geraGuiaGnreSoapType.geraGuiaPDF(sEmpresa, sUsuario, sChaveApi, listaNfe);
  }
  
  public guiasgnre.webgnre.TListaGuias buscaGuiasPendentes(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TRecibos guiasPendentes) throws java.rmi.RemoteException{
    if (geraGuiaGnreSoapType == null)
      _initGeraGuiaGnreSoapTypeProxy();
    return geraGuiaGnreSoapType.buscaGuiasPendentes(sEmpresa, sUsuario, sChaveApi, guiasPendentes);
  }
  
  public guiasgnre.webgnre.TListaGuias buscaTodasGuiasPendentes(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, java.lang.String sDataInicio, java.lang.String sDataFim) throws java.rmi.RemoteException{
    if (geraGuiaGnreSoapType == null)
      _initGeraGuiaGnreSoapTypeProxy();
    return geraGuiaGnreSoapType.buscaTodasGuiasPendentes(sEmpresa, sUsuario, sChaveApi, sDataInicio, sDataFim);
  }
  
  public guiasgnre.webgnre.TListaGuias buscaTodasGuiasComErro(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, java.lang.String sDataInicio, java.lang.String sDataFim) throws java.rmi.RemoteException{
    if (geraGuiaGnreSoapType == null)
      _initGeraGuiaGnreSoapTypeProxy();
    return geraGuiaGnreSoapType.buscaTodasGuiasComErro(sEmpresa, sUsuario, sChaveApi, sDataInicio, sDataFim);
  }
  
  public guiasgnre.webgnre.TListaGuias buscaGuia(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TRetornoLote lote) throws java.rmi.RemoteException{
    if (geraGuiaGnreSoapType == null)
      _initGeraGuiaGnreSoapTypeProxy();
    return geraGuiaGnreSoapType.buscaGuia(sEmpresa, sUsuario, sChaveApi, lote);
  }
  
  public guiasgnre.webgnre.TRetornoLotePDF buscaGuiaPDF(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TRetornoLote lote) throws java.rmi.RemoteException{
    if (geraGuiaGnreSoapType == null)
      _initGeraGuiaGnreSoapTypeProxy();
    return geraGuiaGnreSoapType.buscaGuiaPDF(sEmpresa, sUsuario, sChaveApi, lote);
  }
  
  public guiasgnre.webgnre.TRetornoAssinatura assinatura_gratis(guiasgnre.webgnre.TAssinatura assinatura) throws java.rmi.RemoteException{
    if (geraGuiaGnreSoapType == null)
      _initGeraGuiaGnreSoapTypeProxy();
    return geraGuiaGnreSoapType.assinatura_gratis(assinatura);
  }
  
  
}