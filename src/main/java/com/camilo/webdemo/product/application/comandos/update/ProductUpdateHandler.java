package com.camilo.webdemo.product.application.comandos.update;

import com.camilo.webdemo.category.domain.Category;
import com.camilo.webdemo.category.infraestructure.CategoryEntityMapper;
import com.camilo.webdemo.category.infraestructure.repo.QuerryProductCategorysRepo;
import com.camilo.webdemo.common.application.mediator.RequestHandler;
import com.camilo.webdemo.common.infrastriture.util.FileUtils;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.exception.ProductNotFoundExeption;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import com.camilo.webdemo.productDetail.domain.ProductDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductUpdateHandler implements RequestHandler<ProductUpdateRequest, Void> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;
    private final QuerryProductCategorysRepo querryProductCategorysRepo;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public Void handle(ProductUpdateRequest requst) {

        Producto producto = productRepository.findbyid(requst.getId()).orElseThrow(() -> new ProductNotFoundExeption(requst.getId()));


        ProductDetail productDetail = producto.getProductDetail();
        productDetail.setProvider(requst.getProvider());
        producto.getReviews().add(requst.getReview());
        Category category = querryProductCategorysRepo.findById(requst.getCategory()).
                map(categoryEntityMapper::mapToCategory)
                .orElseThrow(() -> new RuntimeException("category null"));
        producto.getCategories().add(category);
        productRepository.upsert(producto);
        return null;
    }


    @Override
    public Class<ProductUpdateRequest> getReuestType() {
        return ProductUpdateRequest.class;
    }
}
