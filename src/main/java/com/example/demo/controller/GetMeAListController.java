package com.example.demo.controller;

import com.example.demo.dto.ListItemDto;
import com.example.demo.service.ListItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
public class GetMeAListController {

    @Autowired
    private ListItemService listItemService;



    @Operation(summary = "Api to fetch all items in the list")
    @RequestMapping(value = "/all-items")
    @ApiResponse(responseCode = "200", description = "Successfully fetched all items")
    @ApiResponse(responseCode = "500", description = "Something went wrong. Please try again!")
    @ApiResponse(responseCode = "404", description = "Resource not found")
    public List<ListItemDto> getAList(){
        return listItemService.getAllListItems();
    }


    @Operation(summary = "Api to fetch an item based of id")
    @RequestMapping(value = "/item/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added an item"),
            @ApiResponse(responseCode = "500", description = "Something went wrong. Please try again!"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public ListItemDto getAnItem(@PathVariable("id") String id){
        return listItemService.getAnItem(id);
    }

    @Operation(summary = "Api to add an item to list")
    @RequestMapping(value = "/add-item", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added an item"),
            @ApiResponse(responseCode = "500", description = "Something went wrong. Please try again!"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public List<ListItemDto> addAnItem(@RequestBody ListItemDto listItem){
        return listItemService.addAnItem(listItem);
    }
}
