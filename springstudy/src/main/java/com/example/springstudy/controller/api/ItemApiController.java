package com.example.springstudy.controller.api;

import com.example.springstudy.ifs.CrudInterface;
import com.example.springstudy.model.network.Header;
import com.example.springstudy.model.network.request.ItemApiRequest;
import com.example.springstudy.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.*;

public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {
    @Override
    @PostMapping("")
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    @GetMapping("{id}")
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping()
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
