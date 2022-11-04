package com.obra.obras.domain.repository;

import com.obra.obras.domain.entity.Obra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//vai fazer operações na DB
@Repository
public class Obras {

    private static String INSERT = " insert into obra (nome) values (?) ";
    private static String SELECT_ALL = "SELECT * FROM OBRA";
    private static String UPDATE = "update obra set nome = ? where id = ?";
    private static String DELETE = "delete from obra where id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Obra salvar(Obra obra) {
        jdbcTemplate.update(INSERT, new Object[]{obra.getNome()});
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
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                Integer anoConstrucao = rs.getInt("anoConstrucao");
                String coordenacao = rs.getString("coordenacao");
                String gerencia = rs.getString("gerencia");
                String diretoria = rs.getString("diretoria");
                String outorga = rs.getString("outorga");
                String titularidade = rs.getString("titularidade");

                return new Obra(id, nome, anoConstrucao, coordenacao, gerencia, diretoria, outorga, titularidade);
            }
        };
    }
}

