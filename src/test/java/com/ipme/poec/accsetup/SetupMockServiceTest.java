package com.ipme.poec.accsetup;

import com.ipme.poec.accsetup.repository.SetupRepository;
import com.ipme.poec.accsetup.service.SetupService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class SetupMockServiceTest {


    @Autowired
    SetupService setupService;

    @Mock
    private SetupRepository mockSetupRepository;

    @BeforeEach
    void beforeEach() {
        this.setupService.deleteAllSetups();
    }

    @AfterEach
    void afterEach() {
    }


}
