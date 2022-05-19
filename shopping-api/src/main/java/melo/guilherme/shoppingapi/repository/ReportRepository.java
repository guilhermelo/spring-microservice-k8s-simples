package melo.guilherme.shoppingapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import melo.guilherme.shoppingapi.dto.report.ShopReportDTO;
import melo.guilherme.shoppingapi.model.Shop;


public interface ReportRepository {

    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}
