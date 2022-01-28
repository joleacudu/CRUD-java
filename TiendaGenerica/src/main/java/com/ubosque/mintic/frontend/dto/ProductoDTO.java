package com.ubosque.mintic.frontend.dto;

public class ProductoDTO {
	 private String codigoProducto;
	 private String ivacompra;
	 private ProveedorDTO proveedore = new ProveedorDTO();
	 private String nombreProducto;
	 private String precioCompra;
	 private String precioVenta;
	 
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(String ivacompra) {
		this.ivacompra = ivacompra;
	}

	public ProveedorDTO getProveedore() {
		return proveedore;
	}
	public void setProveedore(ProveedorDTO proveedore) {
		this.proveedore = proveedore;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(String precioCompra) {
		this.precioCompra = precioCompra;
	}
	public String getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}
	 
	 
}
