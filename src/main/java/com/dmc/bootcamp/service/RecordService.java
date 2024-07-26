package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.dto.request.RecordRequest;
import com.dmc.bootcamp.repository.FoodRepository;
import com.dmc.bootcamp.repository.RecordRepository;
import com.dmc.bootcamp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;
    private  final FoodRepository foodRepository;

    @Transactional
    public Record saveRecord(RecordRequest recordRequest){
        AppUser user= userRepository.findUserByUserId(recordRequest.getUserId());
        return recordRepository.save(recordRequest.toEntity(user));
        }
    }

    // 사용자 식사 기록 저장
//    public Record save(RecordRequest request) {
//        AppUser appUser = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("User not found: " + request.getUserId()));
//        return recordRepository.save(request.toEntity(appUser));
//    }

    // 사용자 식사 기록 조회
//    public List<Record> getAll() {
//        return recordRepository.findAll();
//    }
//
//    // 사용자 식사 기록 삭제
//    public void delete(long id) {
//        Record record = recordRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Record not found: " + id));
//        recordRepository.delete(record);
//    }

    // 사용자 식사 기록 업데이트
//    @Transactional
//    public Record update(long id, UpdateRecordRequest request) {
//        Record record = recordRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Record not found: " + id));
//        record.update(request.getImage(), request.getContent());
//        return record;
//    }
//    private final FoodRepository foodRepository;

    //유저 개인 정보를 가져와서 총합 칼로리 계산
//    public float getAverageKacl(String userid){
//        AppUser user= userRepository.findById(userid).orElseThrow(()-> new IllegalArgumentException("user not found"));
//        double averageKacl=0;
//        LocalDate birthday= user.getBirthday();
//        Date nowdate = new Date();
//        if(user.getGender().equals("M")){
//            averageKacl=(88.362+(13.397*( user.getWeight()))+(4.799*(user.getHeight()))-(5.677*(Period.between(birthday, LocalDate.now()).getYears())));
//        }
//        else {
//
//            averageKacl=(447.593+(9.247*( user.getWeight()))+(3.098*(user.getHeight()))-(4.330*(Period.between(birthday, LocalDate.now()).getYears())));
//        }
//
//        return (float) averageKacl/3;
//
//    }

    //점수 계산
//    public long getPoint(float kcal, float sugar, float score, float averageKacl ){
//
//        long point=1;
//        //유저 필요한 kcal랑 유저 먹었던 kcal를 비교하고 점수 나오기
//        float gapKcal= kcal-averageKacl;
//
//
//        return  point;
//    }

