package com.camilo.webdemo.product.infrastructure.api;

import com.camilo.webdemo.common.application.mediator.Mediator;
import com.camilo.webdemo.common.domain.PaginationQuerry;
import com.camilo.webdemo.common.domain.PaginationResult;
import com.camilo.webdemo.product.application.comandos.create.ProductCreateRequest;
import com.camilo.webdemo.product.application.comandos.create.ProductCreateResponse;
import com.camilo.webdemo.product.application.comandos.delete.DeleteProductRequest;
import com.camilo.webdemo.product.application.comandos.update.ProductUpdateRequest;
import com.camilo.webdemo.product.application.querry.getByid.GetProductByidResponse;
import com.camilo.webdemo.product.application.querry.getByid.GetProductbyRequest;
import com.camilo.webdemo.product.application.querry.getall.GetAllProductResponse;
import com.camilo.webdemo.product.application.querry.getall.GetProductAllRequest;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.infrastructure.api.dto.CreateProuctDto;
import com.camilo.webdemo.product.infrastructure.api.dto.ProDuctDto;
import com.camilo.webdemo.product.infrastructure.api.dto.UpdateProuctDto;
import com.camilo.webdemo.product.infrastructure.api.mapper.ProuctMapper;
import com.camilo.webdemo.product.infrastructure.database.entity.ProductoFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Product", description = "Product Api operations")
public class ProductController implements ProductApi {
    private final Mediator mediator;

    private final ProuctMapper prouctMapper;

    @Operation(summary = "get all products", description = "get all products")
    @GetMapping("")
    public ResponseEntity<PaginationResult<ProDuctDto>> getAllProducto(@RequestParam(defaultValue = "0") int pageNumber,
                                                                       @RequestParam(defaultValue = "5") int pageSize,
                                                                       @RequestParam(defaultValue = "id") String sortBy,
                                                                       @RequestParam(defaultValue = "asc") String direction,
                                                                       @RequestParam(required = false) String name,
                                                                       @RequestParam(required = false) String descripcion,
                                                                       @RequestParam(required = false) Double priceMax,
                                                                       @RequestParam(required = false) Double priceMin) {
        PaginationQuerry paginationQuerry = new PaginationQuerry(pageNumber, pageSize, sortBy, direction);
        ProductoFilter productoFilter = new ProductoFilter(name, descripcion, priceMin, priceMax);

        log.info("Get All the prodcuts ");
        GetProductAllRequest getProductAllRequest = new GetProductAllRequest(paginationQuerry, productoFilter);
        log.info("Filters: {}", productoFilter);

        GetAllProductResponse response = mediator.dispatch(getProductAllRequest);

        PaginationResult<Producto> productosPage = response.getProductsPage();

        PaginationResult<ProDuctDto> productsPageresult = new PaginationResult<>(
                productosPage.getContent().stream().map(prouctMapper::mapToProductDto).toList(),
                productosPage.getPage(),
                productosPage.getTotalPage(),
                productosPage.getSize(),
                productosPage.getTotalElement()
        );
        log.info("Found  {} products", productsPageresult.getTotalElement());
        return ResponseEntity.ok(productsPageresult);
    }


    @Operation(summary = "get a product by id", description = "get a product by id ")
    @GetMapping("/{id}")
    public ResponseEntity<ProDuctDto> getProductobyid(@PathVariable Long id) {
        log.info("Get  the prodcuts  with id ");
        GetProductByidResponse response = mediator.dispatch(new GetProductbyRequest(id));
        ProDuctDto proDuctDto = prouctMapper.mapToProductDto(response.getProducto());
        log.info("Get product  with id {} ", proDuctDto.getId());
        log.info("DTO categories null? {}", proDuctDto.getCategories() == null);

        return ResponseEntity.ok(proDuctDto);
    }


    @Operation(summary = "save a product", description = "save a products")
    @PostMapping("")
    public ResponseEntity<Void> saveProduct(@Valid @ModelAttribute CreateProuctDto productoDto) {
        log.info(" saving  prodcuts");

        ProductCreateRequest request = prouctMapper.mapToCreateProductRequest(productoDto);


        ProductCreateResponse response = mediator.dispatch(request);
        log.info(response.toString());
        Producto product = response.getProduct();
        log.info(product.toString());
        log.info("Saved product  with id {} ", product.getId());


        return ResponseEntity.created(URI.create("/api/v1/products/".concat(product.getId().toString()))).build();

    }


    @Operation(summary = "update a product", description = "update a product")
    @PutMapping("")
    public ResponseEntity<Void> updateProduct(@Valid @ModelAttribute UpdateProuctDto prouctDto) {
        log.info(" update  the  prodcuts  with id ");

        ProductUpdateRequest request = prouctMapper.mapToUpdateProductRequest(prouctDto);
        mediator.dispatch(request);
        log.info("update  product  with id {} ", prouctDto.getId());

        return ResponseEntity.noContent().build();


    }


    @Operation(summary = "delete a product by id ", description = "delete a  product by id")

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.info(" delete  the  prodcuts  with id: {} ", id);

        mediator.dispatchAsinc(new DeleteProductRequest(id));

        log.info("update  product  with id: {} ", id);

        return ResponseEntity.accepted().build();


    }
}
