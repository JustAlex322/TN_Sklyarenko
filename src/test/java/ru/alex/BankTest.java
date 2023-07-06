package ru.alex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.alex.entity.Bank;
import ru.alex.repository.BankRepository;
import ru.alex.service.Impl.BankServiceImpl;

import static org.mockito.Mockito.when;
import static ru.alex.testData.BankTestData.UPDATED_BANK_NAME;
import static ru.alex.testData.BankTestData.getBanksAfterUpdate;

@ExtendWith(MockitoExtension.class)
class BankTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankServiceImpl bankService;

    @Test
    void testUpdateAllBankNames_ReturnCorrectValues() {

        when(bankRepository.findAll()).thenReturn(getBanksAfterUpdate());

        var updatedBank = bankService.updateAllBankNames(UPDATED_BANK_NAME);

        var updatedBankNameList = updatedBank.stream()
                .map(Bank::getName)
                .toList();

        Assertions.assertNotEquals(0, updatedBankNameList.size());

        Assertions.assertTrue(updatedBankNameList.stream()
                .allMatch(UPDATED_BANK_NAME::equals));
    }
}
