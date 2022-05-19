package melo.guilherme.shoppingapi.dto.report;

public class ShopReportDTO {
    private Integer count;
    private Double total;
    private Double mean;

    public Integer getCount() {
        return count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(final Double total) {
        this.total = total;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(final Double mean) {
        this.mean = mean;
    }
}
