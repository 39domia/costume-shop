package com.service;

import com.model.Tag;

public interface TagService extends IBaseService<Tag>{
    void delete(Long id);

}
