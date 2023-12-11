package com.novel.service;

import java.util.Objects;

import com.novel.model.dbSequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGenerator {
    @Autowired
	private MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq", 101);
        //modify in document
        dbSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        dbSequence.class);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
