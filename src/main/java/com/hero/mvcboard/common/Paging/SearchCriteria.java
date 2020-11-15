package com.hero.mvcboard.common.Paging;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchCriteria extends Criteria {
    private String searchType;
    private String keyword;
}
