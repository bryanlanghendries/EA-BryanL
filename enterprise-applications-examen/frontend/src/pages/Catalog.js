import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Container, Grid, Typography, TextField, MenuItem, FormControl, InputLabel, Select, Button, Box } from '@mui/material';
import ProductCard from "../components/ProductCard";
import { useCart } from "../context/CartContext";

const CATEGORIES = [
    'ALL', 'Food', 'Decor', 'Habitat', 'Animal'
];

const Catalog = () => {
    const [products, setProducts] = useState([]);
    const [filteredProducts, setFilteredProducts] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [selectedCategory, setSelectedCategory] = useState('ALL');

    const { addToCart } = useCart();

    const handleAddToCart = (item) => {
        addToCart(item);
    };

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/products');
                setProducts(response.data);
                setFilteredProducts(response.data);
            } catch (error) {
                console.error('Error fetching products:', error);
            }
        };

        fetchProducts();
    }, []);

    useEffect(() => {
        let updatedProducts = products;

        if (searchTerm) {
            updatedProducts = updatedProducts.filter(product =>
                product.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
                product.description.toLowerCase().includes(searchTerm.toLowerCase())
            );
        }

        if (selectedCategory && selectedCategory !== 'ALL') {
            updatedProducts = updatedProducts.filter(product => product.category === selectedCategory);
        }

        setFilteredProducts(updatedProducts);
    }, [searchTerm, selectedCategory, products]);

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                Product Catalog
            </Typography>

            <Box display="flex" flexDirection="row" justifyContent="space-between" alignItems="flex-start" mb={2}>
                <TextField
                    label="Search"
                    variant="outlined"
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    style={{ marginBottom: '1rem' }}
                />

                <FormControl variant="outlined" style={{ minWidth: 200, marginBottom: '1rem' }}>
                    <InputLabel>Category</InputLabel>
                    <Select
                        value={selectedCategory}
                        onChange={(e) => setSelectedCategory(e.target.value)}
                        label="Category"
                    >
                        {CATEGORIES.map((category) => (
                            <MenuItem key={category} value={category}>
                                {category}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>
            </Box>

            <Grid container spacing={3}>
                {filteredProducts.length > 0 ? (
                    filteredProducts.map((product) => (
                        <Grid item xs={12} sm={6} md={4} key={product.id}>
                            <ProductCard product={product} onAddToCart={handleAddToCart} />
                        </Grid>
                    ))
                ) : (
                    <Typography variant="body1">No products found</Typography>
                )}
            </Grid>
        </Container>
    );
};

export default Catalog;
