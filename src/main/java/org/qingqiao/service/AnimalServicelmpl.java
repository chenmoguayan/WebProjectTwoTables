package org.qingqiao.service;

import org.qingqiao.bean.Animal;
import org.qingqiao.bean.City;
import org.qingqiao.bean.Type;
import org.qingqiao.dao.AnimalDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hj
 * @data 2023/2/1 15:58
 */
public class AnimalServicelmpl implements AnimalService {
    private AnimalDao animalDao =  new AnimalDao();
    @Override
    public ArrayList<Animal> queryAll() {
        ArrayList<Animal> list = animalDao.queryAll();
        return list;
    }

    public int insert(Animal animal1) {
        return animalDao.insert(animal1);
    }

    @Override
    public ArrayList<Type> getType() {
        return animalDao.getTypr();
    }

    @Override
    public Animal queryById(int id) {
        return animalDao.queryById(id);
    }

    @Override
    public int update(int id,Animal animal1) {
        return animalDao.update(id,animal1);
    }

    @Override
    public int delete(int id) {
        return animalDao.delete(id);
    }

    @Override
    public ArrayList<City> getCity(String pid) {
        return animalDao.getCity(pid);
    }


}
