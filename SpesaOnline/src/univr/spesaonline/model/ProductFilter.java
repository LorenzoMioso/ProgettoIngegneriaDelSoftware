package univr.spesaonline.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductFilter {

    List<Prodotto> productList;

    public ProductFilter(List<Prodotto> productList) {
        this.productList = productList;
    }

    public void filterByReparto(Reparto reparto) {
        List<Prodotto> filteredList = new ArrayList();
        for (Prodotto p : productList) {
            if (p.getReparto().equals(reparto.getNome())) {
                filteredList.add(p);
            }
        }
        productList = filteredList;
    }

    public void searchCaratteristica(String caratteristica) throws SQLException {
        ProdottoDaoImpl prodottoDaoImpl = new ProdottoDaoImpl();
        productList = prodottoDaoImpl.getProdottoByCaratteristica(caratteristica);
    }
    public void searchCaratteristicaReparto(String caratteristica, String reparto) throws SQLException{
        ProdottoDaoImpl prodottoDaoImpl = new ProdottoDaoImpl();
        productList = prodottoDaoImpl.getCaratteristicaProdotto(caratteristica);
        List<Prodotto> filteredList = new ArrayList();
        for (Prodotto p : productList) {
            if (p.getReparto().equalsIgnoreCase(reparto)) {
                filteredList.add(p);
            }
        }
        productList = filteredList;
    }
    public void searchMarca(String marca) {
        List<Prodotto> filteredList = new ArrayList();
        for (Prodotto p : productList) {
            if (p.getMarca().equalsIgnoreCase(marca)) {
                filteredList.add(p);
            }
        }
        productList = filteredList;
    }

    public void searchTipo(String tipo) {
        List<Prodotto> filteredList = new ArrayList();
        for (Prodotto p : productList) {
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                filteredList.add(p);
            }
        }
        productList = filteredList;
    }

    public List<Prodotto> getProductList() {
        return productList;
    }

}
