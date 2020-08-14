package com.thoughtworks.rslist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;


@AutoConfigureMockMvc
@SpringBootTest
class RsListApplicationTests {
//    ObjectMapper objectMapper = new ObjectMapper();
//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    RsEventRepository rsEventRepository;
//    @Autowired
//    VoteRepository voteRepository;

//    @AfterEach
//    void cleanup() {
//        voteRepository.deleteAll();
//        rsEventRepository.deleteAll();
//        userRepository.deleteAll();
//    }
//
//    @Test
//    void shouldAddUser() throws Exception {
//        User user = new User("name 0", "female", 19, "a@b.com", "18888888888");
//        String request = objectMapper.writeValueAsString(user);
//
//        mockMvc.perform(post("/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(request))
//                .andExpect(status().isOk());
//
//        List<UserEntity> users = userRepository.findAll();
//        assertEquals(1, users.size());
//        assertEquals("name 0", users.get(0).getUserName());
//    }
//
//    @Test
//    void shouldAddRsEventWhenUserExists() throws Exception {
//        UserEntity user = UserEntity.builder()
//                .userName("name 0")
//                .gender("male")
//                .age(20)
//                .email("12@34.com")
//                .phone("13579246810")
//                .voteNum(3)
//                .build();
//        user = userRepository.save(user);
//        String userId = String.valueOf(user.getId());
//        String json = "{\"eventName\":\"event 0\",\"keyword\":\"key\",\"userId\":" + userId + "}";
//        mockMvc.perform(post("/rs/event")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(status().isCreated());
//
//        List<RsEventEntity> events = rsEventRepository.findAll();
//        assertEquals(1, events.size());
//        assertEquals("event 0", events.get(0).getEventName());
//        assertEquals(user.getId(), events.get(0).getUserId());
//    }
//
//    @Test
//    void shouldAddRsEventFailedWhenUserDoesNotExist() throws Exception {
//        String json = "{\"eventName\":\"event 0\",\"keyword\":\"key\",\"userId\":\"10000\"}";
//        mockMvc.perform(post("/rs/event")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    void shouldDeleteAllEventsWhenDeleteUser() throws Exception {
//        UserEntity user = UserEntity.builder()
//                .userName("user 0")
//                .gender("male")
//                .age(20)
//                .email("12@34.com")
//                .phone("13579246810")
//                .voteNum(3)
//                .build();
//        user = userRepository.save(user);
//        String userId = String.valueOf(user.getId());
//        RsEventEntity event = RsEventEntity.builder()
//                .eventName("event 0")
//                .keyword("key")
//                .userId(user.getId())
//                .build();
//        rsEventRepository.save(event);
//
//        mockMvc.perform(delete("/user/" + userId)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        List<RsEventEntity> events = rsEventRepository.findAll();
//        assertEquals(0, events.size());
//    }
//
//    @Test
//    void shouldGetVoteWhenGivenUserIdAndEventId() throws Exception {
//        UserEntity user = UserEntity.builder()
//                .userName("user 0")
//                .gender("male")
//                .age(20)
//                .email("12@34.com")
//                .phone("13579246810")
//                .voteNum(3)
//                .build();
//        user = userRepository.save(user);
//        RsEventEntity event = RsEventEntity.builder()
//                .eventName("event 0")
//                .keyword("key")
//                .userId(user.getId())
//                .build();
//        event = rsEventRepository.save(event);
//        VoteEntity vote0 = VoteEntity.builder()
//                .localDateTime(LocalDateTime.now())
//                .num(0)
//                .user(user)
//                .rsEvent(event)
//                .build();
//        voteRepository.save(vote0);
//
//        VoteEntity vote1 = VoteEntity.builder()
//                .localDateTime(LocalDateTime.now())
//                .num(1)
//                .user(user)
//                .rsEvent(event)
//                .build();
//        voteRepository.save(vote1);
//
//        VoteEntity vote2 = VoteEntity.builder()
//                .localDateTime(LocalDateTime.now())
//                .num(2)
//                .user(user)
//                .rsEvent(event)
//                .build();
//        voteRepository.save(vote2);
//
//        VoteEntity vote3 = VoteEntity.builder()
//                .localDateTime(LocalDateTime.now())
//                .num(3)
//                .user(user)
//                .rsEvent(event)
//                .build();
//        voteRepository.save(vote3);
//
//        VoteEntity vote4 = VoteEntity.builder()
//                .localDateTime(LocalDateTime.now())
//                .num(4)
//                .user(user)
//                .rsEvent(event)
//                .build();
//        voteRepository.save(vote4);
//
//        VoteEntity vote5 = VoteEntity.builder()
//                .localDateTime(LocalDateTime.now())
//                .num(5)
//                .user(user)
//                .rsEvent(event)
//                .build();
//        voteRepository.save(vote5);
//
//        VoteEntity vote6 = VoteEntity.builder()
//                .localDateTime(LocalDateTime.now())
//                .num(6)
//                .user(user)
//                .rsEvent(event)
//                .build();
//        voteRepository.save(vote6);
//
//        VoteEntity vote7 = VoteEntity.builder()
//                .localDateTime(LocalDateTime.now())
//                .num(7)
//                .user(user)
//                .rsEvent(event)
//                .build();
//        voteRepository.save(vote7);
//
//        VoteEntity vote8 = VoteEntity.builder()
//                .localDateTime(LocalDateTime.now())
//                .num(8)
//                .user(user)
//                .rsEvent(event)
//                .build();
//        voteRepository.save(vote8);
//
//        mockMvc.perform(get("/vote?userId=" + user.getId() + "&rsEventId=" + event.getId())
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(5)));
//
//        mockMvc.perform(get("/vote?userId=" + user.getId() + "&rsEventId=" + event.getId() + "&pageIndex=" + 2)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(4)));
//    }


}
