package org.plateer.backlms.member.controlleradvice;

import org.plateer.backlms.common.dto.ResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class MemberControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ResultDTO> duplicateMember(SQLIntegrityConstraintViolationException exception) {
        return ResponseEntity.badRequest().body(new ResultDTO("Duplicate Member"));
    }

}
