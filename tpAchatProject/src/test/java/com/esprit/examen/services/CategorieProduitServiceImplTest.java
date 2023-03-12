package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;

public class CategorieProduitServiceImplTest {

    @Mock
    private CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    private CategorieProduitServiceImpl categorieProduitService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllCategorieProduits() {
        // create some test data
        CategorieProduit cp1 = new CategorieProduit();
        cp1.setId(1L);
        cp1.setNom("Category 1");
        CategorieProduit cp2 = new CategorieProduit();
        cp2.setId(2L);
        cp2.setNom("Category 2");
        List<CategorieProduit> categorieProduits = new ArrayList<>();
        categorieProduits.add(cp1);
        categorieProduits.add(cp2);

        // tell the mock object what to return
        when(categorieProduitRepository.findAll()).thenReturn(categorieProduits);

        // call the method under test
        List<CategorieProduit> result = categorieProduitService.retrieveAllCategorieProduits();

        // verify the results
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(cp1, result.get(0));
        assertEquals(cp2, result.get(1));

        // verify that the repository method was called once
        verify(categorieProduitRepository, times(1)).findAll();
    }

    @Test
    public void testAddCategorieProduit() {
        // create some test data
        CategorieProduit cp = new CategorieProduit();
        cp.setId(1L);
        cp.setNom("Category 1");

        // tell the mock object what to return
        when(categorieProduitRepository.save(cp)).thenReturn(cp);

        // call the method under test
        CategorieProduit result = categorieProduitService.addCategorieProduit(cp);

        // verify the results
        assertNotNull(result);
        assertEquals(cp, result);

        // verify that the repository method was called once
        verify(categorieProduitRepository, times(1)).save(cp);
    }

    @Test
    public void testDeleteCategorieProduit() {
        // create some test data
        Long id = 1L;

        // call the method under test
        categorieProduitService.deleteCategorieProduit(id);

        // verify that the repository method was called once
        verify(categorieProduitRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateCategorieProduit() {
        // create some test data
        CategorieProduit cp = new CategorieProduit();
        cp.setId(1L);
        cp.setNom("Category 1");

        // tell the mock object what to return
        when(categorieProduitRepository.save(cp)).thenReturn(cp);

        // call the method under test
        CategorieProduit result = categorieProduitService.updateCategorieProduit(cp);

        // verify the results
        assertNotNull(result);
    }
}
