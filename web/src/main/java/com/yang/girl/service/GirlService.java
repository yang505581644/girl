package com.yang.girl.service;

import com.yang.girl.domain.Girl;
import com.yang.girl.enums.ResultEnum;
import com.yang.girl.exception.GirlException;
import com.yang.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girl = new Girl();
        girl.setCupSize("A");
        girl.setAge(18);
        girlRepository.save(girl);

        Girl girl2 = new Girl();
        girl2.setCupSize("B");
        girl2.setAge(19);
        girlRepository.save(girl2);
    }

    public void getAge(Integer id) throws GirlException{
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        if (age <=10) {
            //返回"你还在上小学吧 code 100"
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回"你可能在上初中 code 101"
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        //如果>16岁,加钱
        //...

    }

    /**
     *通过Id查询一个女生的信息
     * @param id
     * @return
     * */
    public Girl findOne(Integer id) {
        return girlRepository.findById(id).orElse(null);
    }
}
