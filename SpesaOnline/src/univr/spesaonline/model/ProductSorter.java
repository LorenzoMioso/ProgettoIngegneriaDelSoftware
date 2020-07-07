package univr.spesaonline.model;

import java.util.Collections;
import java.util.List;

public class ProductSorter {

    List<Prodotto> productList;

    public ProductSorter(List<Prodotto> productList) {
        this.productList = productList;
    }

    public void SortByPrezzoCrescente() {
        Collections.sort(productList, Prodotto.prezzoComparator);
    }

    public void SortByPrezzoDecrescente() {
        Collections.sort(productList, Prodotto.prezzoComparator.reversed());
    }

    public void SortByMarcaCrescente() {
        Collections.sort(productList, Prodotto.marcaComparator);
    }

    public void SortByMarcaDecrescente() {
        Collections.sort(productList, Prodotto.marcaComparator.reversed());
    }

    public List<Prodotto> getProductList() {
        return productList;
    }
}
