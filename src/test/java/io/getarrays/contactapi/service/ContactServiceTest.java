package io.getarrays.contactapi.service;

import io.getarrays.contactapi.domain.Contact;
import io.getarrays.contactapi.repo.ContactRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ContactServiceTest {

    @Mock
    private ContactRepo contactRepo;

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        contactService = new ContactService(contactRepo);
    }

    @Test
    public void testGetAllContacts() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("name"));
        Page<Contact> page = mock(Page.class);
        when(contactRepo.findAll(pageRequest)).thenReturn(page);

        assertEquals(page, contactService.getAllContacts(0, 10));
        verify(contactRepo, times(1)).findAll(pageRequest);
    }

    @Test
    public void testGetContact() {
        Contact contact = new Contact();
        contact.setId("1");
        when(contactRepo.findById("1")).thenReturn(Optional.of(contact));

        assertEquals(contact, contactService.getContact("1"));
        verify(contactRepo, times(1)).findById("1");
    }

    @Test
    public void testGetContactNotFound() {
        when(contactRepo.findById("1")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> contactService.getContact("1"));
        verify(contactRepo, times(1)).findById("1");
    }

    @Test
    public void testCreateContact() {
        Contact contact = new Contact();
        when(contactRepo.save(contact)).thenReturn(contact);

        assertEquals(contact, contactService.createContact(contact));
        verify(contactRepo, times(1)).save(contact);
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact();
        contact.setId("1");

        doNothing().when(contactRepo).deleteById("1");

        contactService.deleteContact(contact.getId());
        verify(contactRepo, times(1)).deleteById("1");
    }

}