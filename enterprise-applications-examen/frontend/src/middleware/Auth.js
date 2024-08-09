import { Navigate, Outlet } from 'react-router-dom';

const Auth = ({ Component }) => {
  const token = localStorage.getItem('authToken');
  if (token) {
    return Component;
  }
    return <Navigate to="/login" />;
};

export default Auth;