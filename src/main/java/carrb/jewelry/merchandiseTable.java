package carrb.jewelry;

public class merchandiseTable {
    String id, manufacturer, model, type, material, sample, weight, warranty, price, quantOnStok, description;

    public merchandiseTable (String id, String manufacturer, String model, String type, String material, String sample,
                             String weight, String warranty, String price, String quantOnStok, String description){
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.material = material;
        this.sample = sample;
        this.weight = weight;
        this.warranty = warranty;
        this.price = price;
        this.quantOnStok = quantOnStok;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantOnStok() {
        return quantOnStok;
    }

    public void setQuantOnStok(String quantOnStok) {
        this.quantOnStok = quantOnStok;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
