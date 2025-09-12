package com.happen.happen_app.service.impl;
import org.springframework.stereotype.Service;
import com.happen.happen_app.entity.TicketType;
import com.happen.happen_app.dto.TicketTypeDto;
import com.happen.happen_app.mapper.TicketTypeMapper;
import com.happen.happen_app.repository.TicketTypeRepository;
import com.happen.happen_app.service.TicketTypeService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {

    private TicketTypeRepository ticketTypeRepository;

    public TicketTypeServiceImpl(TicketTypeRepository ticketTypeRepository) {
        this.ticketTypeRepository = ticketTypeRepository;
    }

    @Override
    public TicketTypeDto createTicketType(TicketTypeDto ticketTypeDto) {
        TicketType ticketType = TicketTypeMapper.mapToTicketType(ticketTypeDto);
        TicketType savedTicketType = ticketTypeRepository.save(ticketType);
        return TicketTypeMapper.mapToTicketTypeDto(savedTicketType);
    }

    @Override
    public TicketTypeDto getTicketTypeById(Long id) {
        TicketType ticketType = ticketTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TicketType does not exist"));
        return TicketTypeMapper.mapToTicketTypeDto(ticketType);
    }

    @Override
    public List<TicketTypeDto> getAllTicketTypes() {
        return ticketTypeRepository.findAll()
                .stream()
                .map(TicketTypeMapper::mapToTicketTypeDto)
                .collect(Collectors.toList());
    }


    @Override
    public TicketTypeDto updateTicketType(Long id, TicketTypeDto ticketTypeDto) {
        TicketType ticketType = ticketTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TicketType does not exist"));


        ticketType.setId(ticketTypeDto.getId());
        ticketType.setTitle(ticketTypeDto.getTitle());
        ticketType.setDescription(ticketTypeDto.getDescription());
        ticketType.setPrice(ticketTypeDto.getPrice());
        ticketType.setQuantityAvailable(ticketTypeDto.getQuantityAvailable());
        ticketType.setQuantitySold(ticketTypeDto.getQuantitySold());
        ticketType.setSaleStartDate(ticketTypeDto.getSaleStartDate());
        ticketType.setSaleEndDate(ticketTypeDto.getSaleEndDate());
        ticketType.setIsActive(ticketTypeDto.getIsActive());


        TicketType updatedTicketType = ticketTypeRepository.save(ticketType);
        return TicketTypeMapper.mapToTicketTypeDto(updatedTicketType);
    }

    @Override
    public void deleteTicketType(Long id) {
        if (!ticketTypeRepository.existsById(id)) {
            throw new RuntimeException("TicketType does not exist");
        }
        ticketTypeRepository.deleteById(id);
    }

}