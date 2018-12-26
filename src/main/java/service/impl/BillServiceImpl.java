package service.impl;

import dao.BillDao;
import model.PageService;
import model.Bill;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BillService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("billService")
public class BillServiceImpl implements BillService {

    @Resource
    private BillDao billDao;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public Bill findByColumn(String column, String key) {
        HashMap map = new HashMap();
        map.put("column", column);
        map.put("key", "'" + key + "'");
        return this.billDao.findByColumn(map);
    }

    @Override
    public List<Bill> findList() {
        return this.billDao.findList();
    }

    @Override
    public void addBill(Bill bill) {
        this.billDao.addBill(bill);
    }

    @Override
    public void delBillById(int id) {
        this.billDao.delBillById(id);
    }

    @Override
    public void updateBillById(Bill bill) {
        this.billDao.updateBillById(bill);
    }

    @Override
    public void delsBill(List<Integer> list) {
        this.billDao.delsBill(list);
    }

    @Override
    public int getCountByName(String name) {
        return this.billDao.getCountByName(name);
    }

    @Override
    public List<Bill> findBillPage(PageService pageService) {
        return this.billDao.findBillPage(pageService);
    }
}
