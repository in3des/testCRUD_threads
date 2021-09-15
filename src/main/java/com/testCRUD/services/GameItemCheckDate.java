package com.testCRUD.services;

import com.testCRUD.model.GameItem;
import com.testCRUD.model.enums.Status;
import com.testCRUD.repository.GameItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameItemCheckDate {

    @Autowired
    private GameItemServices gameItemServices;

    private static String currentDate = "01-01-2011";


    public void gameItemCheckDate(GameItemServices gameItemServices) {
        List<GameItem> checkList = gameItemServices.listAll();
        System.out.println("<<< --- Check Date results: --- >>>");
        List<GameItem> updateList = checkList.parallelStream()
                .filter(gameItem -> gameItem.getReleaseDate().equals(currentDate) && gameItem.getStatus().equals(Status.PRODUCTION))
//                .forEach(System.out::println);
                .collect(Collectors.toList());
        System.out.println(updateList);
        System.out.println("<<< --- Check Date END --- >>>");
    }

    @PostConstruct
    private void checkTestGameItem() {
        gameItemCheckDate(gameItemServices);
    }
}
