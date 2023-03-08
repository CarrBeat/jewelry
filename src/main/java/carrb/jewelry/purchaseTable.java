package carrb.jewelry;

public class purchaseTable {

    String idPurchase, merchandiseId, paySum, client, seller, purchaseDate;

    public purchaseTable (String idPurchase, String merchandiseId, String paySum, String client, String seller,
                          String purchaseDate){
        this.idPurchase = idPurchase;
        this.merchandiseId = merchandiseId;
        this.paySum = paySum;
        this.client = client;
        this.seller = seller;
        this.purchaseDate = purchaseDate;
    }

    public String getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(String idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(String merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public String getPaySum() {
        return paySum;
    }

    public void setPaySum(String paySum) {
        this.paySum = paySum;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
