package dev.easley.models;

public class SupplyRequests {


    private Integer req_id;
    private Integer req_rec_amount;
    private String resource;


    public SupplyRequests() {

    }

    public SupplyRequests(String resource, Integer req_rec_amount) {
        this.resource = resource;
        this.req_rec_amount = req_rec_amount;
    }

    public SupplyRequests(Integer req_id, Integer req_rec_amount, String resource) {
        this.req_id = req_id;
        this.req_rec_amount = req_rec_amount;
        this.resource = resource;
    }

    public Integer getReq_id() {
        return req_id;
    }

    public void setReq_id(Integer req_id) {
        this.req_id = req_id;
    }

    public Integer getReq_rec_amount() {
        return req_rec_amount;
    }

    public void setReq_rec_amount(Integer req_rec_amount) {
        this.req_rec_amount = req_rec_amount;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "SupplyRequests{" +
                "req_id=" + req_id +
                ", req_rec_amount=" + req_rec_amount +
                ", resource='" + resource + '\'' +
                '}';
    }
}
