package com.example.DicionarioPlantae.component;

import com.example.DicionarioPlantae.entity.CategoriaTaxonomica;
import com.example.DicionarioPlantae.entity.ClassificacaoAngiosperma;
import com.example.DicionarioPlantae.entity.Origem;
import com.example.DicionarioPlantae.repository.CategoriaTaxonomicaRepository;
import com.example.DicionarioPlantae.repository.ClassificacaoAngiospermaRepository;
import com.example.DicionarioPlantae.repository.OrigemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoriaTaxonomicaRepository categoriaRepository;
    private final ClassificacaoAngiospermaRepository classificacaoRepository;
    private final OrigemRepository origemRepository;

    public DataLoader(CategoriaTaxonomicaRepository categoriaRepository,
            ClassificacaoAngiospermaRepository classificacaoRepository,
            OrigemRepository origemRepository) {
        this.categoriaRepository = categoriaRepository;
        this.classificacaoRepository = classificacaoRepository;
        this.origemRepository = origemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategorias();
        loadClassificacoes();
        loadOrigens();
    }

    private void loadCategorias() {
        if (categoriaRepository.count() == 0) {
            CategoriaTaxonomica c1 = new CategoriaTaxonomica();
            c1.setNome("Briófitas");
            c1.setStatus(1);
            CategoriaTaxonomica c2 = new CategoriaTaxonomica();
            c2.setNome("Pteridófitas");
            c2.setStatus(1);
            CategoriaTaxonomica c3 = new CategoriaTaxonomica();
            c3.setNome("Gimnospermas");
            c3.setStatus(1);
            CategoriaTaxonomica c4 = new CategoriaTaxonomica();
            c4.setNome("Angiospermas");
            c4.setStatus(1);
            categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
            System.out.println("Categorias carregadas.");
        }
    }

    private void loadClassificacoes() {
        if (classificacaoRepository.count() == 0) {
            ClassificacaoAngiosperma c1 = new ClassificacaoAngiosperma();
            c1.setNome("N/A (Não Aplicável)");
            c1.setStatus(1);
            ClassificacaoAngiosperma c2 = new ClassificacaoAngiosperma();
            c2.setNome("Basais");
            c2.setStatus(1);
            ClassificacaoAngiosperma c3 = new ClassificacaoAngiosperma();
            c3.setNome("Monocotiledôneas");
            c3.setStatus(1);
            ClassificacaoAngiosperma c4 = new ClassificacaoAngiosperma();
            c4.setNome("Eudicotiledôneas");
            c4.setStatus(1);
            classificacaoRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
            System.out.println("Classificações carregadas.");
        }
    }

    private void loadOrigens() {
        if (origemRepository.count() == 0) {
            Origem o1 = new Origem();
            o1.setTipo("Nativa");
            o1.setStatus(1);
            Origem o2 = new Origem();
            o2.setTipo("Exótica");
            o2.setStatus(1);
            Origem o3 = new Origem();
            o3.setTipo("Cultivada");
            o3.setStatus(1);
            Origem o4 = new Origem();
            o4.setTipo("Espontânea");
            o4.setStatus(1);
            origemRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
            System.out.println("Origens carregadas.");
        }
    }
}
