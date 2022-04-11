package kr.imcf.mybatis.account;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountController {
    // 로깅에 사용하는 라이브러리 (@Slf4j 필요)
    private static final Logger logger = LogManager.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public AccountResponse getAccountAll(){
        logger.trace("요청이 들어왔습니다");
        return accountService.getAccountAll();
    }

}
