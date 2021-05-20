package ru.skillfactorydemo.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.Income;
import ru.skillfactorydemo.tgbot.entity.Spend;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SpendRepositoryTest {

    @Autowired
    private SpendRepository spendRepository;

    @Test
    public void testRepo() {
        //noinspection StatementWithEmptyBody
        for (int i = 0; i < 10; i++, spendRepository.save(new Spend()));
        final List<Spend> found = spendRepository.findAll();
        assertEquals(11, found.size());
    }

    @Test
    public void testDataScripts() {
        Optional<Spend> byId = spendRepository.findById(12345L);
        assertTrue(byId.isPresent());
        assertEquals(new BigDecimal("10.00"), byId.get().getSpend());
    }
}