package org.qingqiao.service;

import org.qingqiao.bean.Animal;
import org.qingqiao.bean.City;
import org.qingqiao.bean.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hj
 * @data 2023/2/1 15:56
 */
public interface AnimalService {

    ArrayList<Animal> queryAll();

    int insert(Animal animal);

    ArrayList<Type> getType();

    Animal queryById(int id);

    int update(int id, Animal animal1);

    int delete(int id);

    List<City> getCity(String pid);
}
