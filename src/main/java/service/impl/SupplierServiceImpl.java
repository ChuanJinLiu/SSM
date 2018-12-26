package service.impl;

import dao.SupplierDao;
import model.Supplier;
import model.PageService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SupplierService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

    @Resource
    private SupplierDao supplierDao;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public Supplier findByColumn(String column, String key) {
        HashMap map = new HashMap();
        map.put("column", column);
        map.put("key", "'" + key + "'");
        return this.supplierDao.findByColumn(map);
    }

    @Override
    public List<Supplier> findList() {
        return this.supplierDao.findList();
    }

    @Override
    public void addSupplier(Supplier supplier) {
        this.supplierDao.addSupplier(supplier);
    }

    @Override
    public void delSupplierById(int id) {
        this.supplierDao.delSupplierById(id);
    }

    @Override
    public void updateSupplierById(Supplier supplier) {
        this.supplierDao.updateSupplierById(supplier);
    }

    @Override
    public void delsSupplier(List<Integer> list) {
        this.supplierDao.delsSupplier(list);
    }

    @Override
    public int getCountByName(String name) {
        return this.supplierDao.getCountByName(name);
    }

    @Override
    public List<Supplier> findSupplierPage(PageService pageService) {
        return this.supplierDao.findSupplierPage(pageService);
    }
}
