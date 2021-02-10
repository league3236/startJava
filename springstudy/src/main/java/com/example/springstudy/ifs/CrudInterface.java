package com.example.springstudy.ifs;

import com.example.springstudy.model.network.Header;

public interface CrudInterface {
    Header create();        // todo request object 추가

    Header read(Long id);

    Header update();

    Header delete(Long id);
}
