package com.hibernatevalidator;

import com.hibernatevalidator.model.Article;
import com.hibernatevalidator.model.Author;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

/**
 * @ClassName ValidatorTest
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/25 16:52
 */
public class ValidatorTest {
    private static ValidatorFactory factory;
    private static Validator validator;
    private static Logger logger;

    @BeforeClass
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        logger = LoggerFactory.getLogger(ValidatorTest.class);
    }

    @AfterClass
    public static void clean() {
        factory.close();
    }

    @Test
    public void testKindsOfErrors() {
        Author author = new Author();
        author.setUsername("123");
        author.setPassword("1234");
        author.setAddress("");
        author.setEmail("");
        author.setArticles(null);
        author.setAge(-20);
        Set<ConstraintViolation<Author>> set = validator.validate(author);
        for (ConstraintViolation<Author> c : set) {
            logger.info(c.toString());
        }
    }

    @Test
    public void testAllRight() {
        Author author = new Author();
        author.setUsername("yitian");
        author.setPassword("12345678");
        author.setAddress("");
        author.setNickname("");
        author.setEmail("yitian@yitian.com");
        author.setBirthday(new Date());
        Set<ConstraintViolation<Author>> set = validator.validate(author);
        for (ConstraintViolation<Author> c : set) {
            logger.info(c.toString());
        }
        Assert.assertEquals(0, set.size());
    }

    @Test
    public void testOneProperty() {
        Author author = new Author();
        author.setUsername("yitian");
        Set<ConstraintViolation<Author>> set = validator.validateProperty(author, "username");
        for (ConstraintViolation<Author> c : set) {
            logger.info(c.toString());
        }
    }

    @Test
    public void testCustomMessage() {
        Article article = new Article();
        LocalDate date = LocalDate.of(2099, 1, 1);
        article.setModifyTime(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Set<ConstraintViolation<Article>> set = validator.validateProperty(article, "modifyTime");
        for (ConstraintViolation<Article> c : set) {
            logger.info(c.toString());
        }
    }
}
