package com.example.demo.service;

import com.example.demo.dto.ListItemDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ListItemService {

    private List<ListItemDto> listItems = new ArrayList<>(Arrays.asList(
            new ListItemDto("1", "One", "Something"),
            new ListItemDto("2", "two", "Else")
    ));

    public List<ListItemDto> getAllListItems(){
        return listItems;
    }

    public ListItemDto getAnItem(String id){
        return listItems.stream().filter(item -> item.getId().equals(id)).findFirst().get();
    }

    public List<ListItemDto> addAnItem(ListItemDto listItem){
        listItems.add(listItem);
        return listItems;
    }
}
