package com.obra.obras.domain.repository;

import com.obra.obras.domain.entity.Obra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//vai fazer operações na DB
@Repository
public class Obras {


    private static String SELECT_ALL = "SELECT * FROM obra";
    private static String UPDATE = "update obra set nome = ? where id = ?";
    private static String DELETE = "delete from obra where id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Obra salvar(Obra obra) {
        entityManager.persist(obra);
        return obra;
    }

    public Obra atualizar(Obra obra) {
        jdbcTemplate.update(UPDATE, new Object[]{
                obra.getNome(),
                obra.getId()});
        return obra;
    }

    public void deletar(Obra obra) {
        deletar(obra.getId());
    }

    public void deletar(Integer id) {
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    public List<Obra> buscarPorNome(String nome) {
        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like ?"),
                new Object[]{"%" + nome + "%"},
                getObraRowMapper());
    }

    public List<Obra> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, getObraRowMapper());
    }

    private static RowMapper<Obra> getObraRowMapper() {
        return new RowMapper<Obra>() {
            @Override
            public Obra mapRow(ResultSet rs, int rowNum) throws SQLException {

                String nome = rs.getString("nome");
                Integer anoConstrucao = rs.getInt("ano_construcao");
                String coordenacao = rs.getString("coordenacao");
                String gerencia = rs.getString("gerencia");
                String diretoria = rs.getString("diretoria");
                String outorga = rs.getString("outorga");
                String titularidade = rs.getString("titularidade");

                return new Obra( nome, anoConstrucao, coordenacao, gerencia, diretoria, outorga, titularidade);
            }
        };
    }
}

