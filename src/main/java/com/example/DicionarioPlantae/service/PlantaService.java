package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.dto.request.PlantaDTORequest;
import com.example.DicionarioPlantae.entity.CategoriaTaxonomica;
import com.example.DicionarioPlantae.entity.ClassificacaoAngiosperma;
import com.example.DicionarioPlantae.entity.Origem;
import com.example.DicionarioPlantae.entity.Planta;
import com.example.DicionarioPlantae.repository.CategoriaTaxonomicaRepository;
import com.example.DicionarioPlantae.repository.ClassificacaoAngiospermaRepository;
import com.example.DicionarioPlantae.repository.OrigemRepository;
import com.example.DicionarioPlantae.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaService {

        private final PlantaRepository plantaRepository;
        private final CategoriaTaxonomicaRepository categoriaTaxonomicaRepository;
        private final ClassificacaoAngiospermaRepository classificacaoAngiospermaRepository;
        private final OrigemRepository origemRepository;

        @Autowired
        public PlantaService(PlantaRepository plantaRepository,
                        CategoriaTaxonomicaRepository categoriaTaxonomicaRepository,
                        ClassificacaoAngiospermaRepository classificacaoAngiospermaRepository,
                        OrigemRepository origemRepository) {
                this.plantaRepository = plantaRepository;
                this.categoriaTaxonomicaRepository = categoriaTaxonomicaRepository;
                this.classificacaoAngiospermaRepository = classificacaoAngiospermaRepository;
                this.origemRepository = origemRepository;
        }

        public List<Planta> listarPlanta() {
                return plantaRepository.findAll();
        }

        public Planta criarPlanta(PlantaDTORequest plantaDTORequest) {
                CategoriaTaxonomica categoria = categoriaTaxonomicaRepository
                                .findById(plantaDTORequest.getCategoriaTaxonomicaId())
                                .orElseThrow(() -> new RuntimeException("Categoria Taxonomica não encontrada"));

                ClassificacaoAngiosperma classificacao = classificacaoAngiospermaRepository
                                .findById(plantaDTORequest.getClassificacaoAngiospermaId())
                                .orElseThrow(() -> new RuntimeException("Classificação Angiosperma não encontrada"));

                Origem origem = origemRepository.findById(plantaDTORequest.getOrigemId())
                                .orElseThrow(() -> new RuntimeException("Origem não encontrada"));

                Planta planta = new Planta();
                planta.setCientifico(plantaDTORequest.getCientifico());
                planta.setPopular(plantaDTORequest.getPopular());
                planta.setComestivel(plantaDTORequest.getComestivel());
                planta.setStatus(plantaDTORequest.getStatus());
                planta.setCategoriaTaxonomica(categoria);
                planta.setClassificacaoAngiosperma(classificacao);
                planta.setOrigem(origem);

                return plantaRepository.save(planta);
        }

        public Planta atualizarPlanta(Integer id, PlantaDTORequest plantaDTORequest) {
                Planta planta = plantaRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Planta não encontrada"));

                CategoriaTaxonomica categoria = categoriaTaxonomicaRepository
                                .findById(plantaDTORequest.getCategoriaTaxonomicaId())
                                .orElseThrow(() -> new RuntimeException("Categoria Taxonomica não encontrada"));

                ClassificacaoAngiosperma classificacao = classificacaoAngiospermaRepository
                                .findById(plantaDTORequest.getClassificacaoAngiospermaId())
                                .orElseThrow(() -> new RuntimeException("Classificação Angiosperma não encontrada"));

                Origem origem = origemRepository.findById(plantaDTORequest.getOrigemId())
                                .orElseThrow(() -> new RuntimeException("Origem não encontrada"));

                planta.setCientifico(plantaDTORequest.getCientifico());
                planta.setPopular(plantaDTORequest.getPopular());
                planta.setComestivel(plantaDTORequest.getComestivel());
                planta.setStatus(plantaDTORequest.getStatus());
                planta.setCategoriaTaxonomica(categoria);
                planta.setClassificacaoAngiosperma(classificacao);
                planta.setOrigem(origem);

                return plantaRepository.save(planta);
        }

        public List<Planta> buscarPorNome(String nome) {
                return plantaRepository.findByPopularContainingIgnoreCase(nome);
        }

        public Planta obterPorId(Integer id) {
                return plantaRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Planta não encontrada"));
        }

        public void deletarPlanta(Integer id) {
                plantaRepository.apagarPlanta(id);
        }
}
