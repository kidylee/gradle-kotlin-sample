package cn.org.aiit.ddex.repository.search

import cn.org.aiit.ddex.domain.User
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
interface UserSearchRepository : ElasticsearchRepository<User, Long>
