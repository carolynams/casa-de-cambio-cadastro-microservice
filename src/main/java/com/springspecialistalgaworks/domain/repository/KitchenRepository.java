package com.springspecialistalgaworks.domain.repository;

import java.util.List;
import com.springspecialistalgaworks.domain.model.Kitchen;

public interface KitchenRepository {

    List<Kitchen> listAll();

    Kitchen findById(Long id);

    Kitchen save(Kitchen kitchen);

    void delete(Kitchen kitchen);


}
